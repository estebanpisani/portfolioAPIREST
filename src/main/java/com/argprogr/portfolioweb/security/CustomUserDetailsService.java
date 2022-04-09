package com.argprogr.portfolioweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.model.Usuario;
import com.argprogr.portfolioweb.model.UsuarioPrincipal;
import com.argprogr.portfolioweb.service.UsuarioService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByUsername(username).get();
		return UsuarioPrincipal.build(usuario);

	}

}
