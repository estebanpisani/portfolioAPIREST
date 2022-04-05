package com.argprogr.portfolioweb.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.model.Rol;
import com.argprogr.portfolioweb.model.Usuario;
import com.argprogr.portfolioweb.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Buscamos si existe el usuario.
		Usuario usuario = usuarioRepo.findByUsername(username).orElseThrow(
				()-> new UsernameNotFoundException("Usuario "+username+" no encontrado.")
				);
		//Si existe devolvemos un User con sus credenciales.
		return new User(usuario.getUsername(), usuario.getPasword(), mapearRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles){
		return roles
				.stream()
				.map(rol -> 
				new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}
}
