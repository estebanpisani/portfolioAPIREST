package com.argprogr.portfolioweb.security;

import com.argprogr.portfolioweb.dto.UserDTO;
import com.argprogr.portfolioweb.enums.RolNombre;
import com.argprogr.portfolioweb.model.Rol;
import com.argprogr.portfolioweb.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.model.Usuario;
import com.argprogr.portfolioweb.model.UsuarioPrincipal;
import com.argprogr.portfolioweb.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	RolService rolService;
	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByUsername(username).get();
		return UsuarioPrincipal.build(usuario);

	}

	public boolean save(UserDTO userDTO) {
		Usuario usuario = new Usuario();
		usuario.setUsername(userDTO.getUsername());
		usuario.setPasword(passwordEncoder.encode(userDTO.getPassword()));
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		if(usuario.getRoles().contains("admin")){
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
			usuario.setRoles(roles);
		}
		usuarioService.saveUsuario(usuario);

		return usuario!=null;
	}

}
