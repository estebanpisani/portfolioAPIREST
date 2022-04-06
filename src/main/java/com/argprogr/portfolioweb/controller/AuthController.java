package com.argprogr.portfolioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprogr.portfolioweb.dto.UserDTO;
import com.argprogr.portfolioweb.repository.UsuarioRepository;
import com.argprogr.portfolioweb.security.JWTAuthResponseDTO;
import com.argprogr.portfolioweb.security.JWTTokenProvider;
import com.argprogr.portfolioweb.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsuarioRepository usuarioRepo;
	@Autowired
	UsuarioService usuarioService;

	@Autowired
	JWTTokenProvider tokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponseDTO> authenticateUser(@RequestBody UserDTO dto){
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//Obtener token del Provider
		String token = tokenProvider.generateToken(authentication);
		
		
		
		return ResponseEntity.ok(new JWTAuthResponseDTO(token));
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDTO dto){
		if(usuarioRepo.existsByUsername(dto.getUsername())) {
			return new ResponseEntity<String>("Nombre de Usuario ya existe.", HttpStatus.BAD_REQUEST);
		}
		//Booleano para indicar si es admin o no.
		usuarioService.saveUsuario(dto, false);
		
		return new ResponseEntity<String>("Usuario registrado con éxito.", HttpStatus.CREATED);
	}
	

}
