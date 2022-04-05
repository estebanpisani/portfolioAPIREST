package com.argprogr.portfolioweb.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprogr.portfolioweb.dto.UserDTO;
import com.argprogr.portfolioweb.model.Rol;
import com.argprogr.portfolioweb.model.Usuario;
import com.argprogr.portfolioweb.repository.RolRepository;
import com.argprogr.portfolioweb.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsuarioRepository usuarioRepo;
	@Autowired
	RolRepository rolRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody UserDTO dto){
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseEntity<String>("Sesión iniciada con éxito.", HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDTO dto){
		if(usuarioRepo.existsByUsername(dto.getUsername())) {
			return new ResponseEntity<String>("Nombre de Usuario ya existe.", HttpStatus.BAD_REQUEST);
		}
		/**
		 * TODO Desarrollar usuario service
		 */
		
		Usuario usuario = new Usuario();
		usuario.setUsername(dto.getUsername());
		usuario.setPasword(passwordEncoder.encode(dto.getPassword()));
		
		Rol rol = rolRepo.findByNombre("ROLE_ADMIN").get();
		usuario.setRoles(Collections.singleton(rol));
		
		usuarioRepo.save(usuario);
		
		return new ResponseEntity<String>("Usuario registrado con éxito.", HttpStatus.CREATED);
	}
	

}
