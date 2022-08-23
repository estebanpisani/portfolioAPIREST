package com.argprogr.portfolioweb.controller;

import com.argprogr.portfolioweb.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprogr.portfolioweb.dto.JwtDTO;
import com.argprogr.portfolioweb.dto.Mensaje;
import com.argprogr.portfolioweb.dto.UserDTO;
import com.argprogr.portfolioweb.repository.UsuarioRepository;
import com.argprogr.portfolioweb.security.JWTTokenProvider;
import com.argprogr.portfolioweb.service.RolService;
import com.argprogr.portfolioweb.service.UsuarioService;


@RestController
@CrossOrigin(origins = "https://estebanpisaniportfolio.web.app")
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	CustomUserDetailsService userDetailsService;
	@Autowired
	JWTTokenProvider tokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<JwtDTO> login(@RequestBody UserDTO dto, BindingResult bindingResult){
		
        if(bindingResult.hasErrors()) {
        	return new ResponseEntity(new Mensaje("Campos mal puestos."), HttpStatus.BAD_REQUEST);
        }
            
		Authentication authentication = 
				authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//Obtener token del Provider
		String token = tokenProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		JwtDTO jwtDto = new JwtDTO(token, userDetails.getUsername(), userDetails.getAuthorities()); 
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserDTO user) throws Exception{
		userDetailsService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	/*
	//TODO Arreglar. Siempre elimina aunque no encuentre usuario.
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		Optional<Usuario> opt = usuarioRepo.findById(id);
		
			if (opt.isEmpty()){
				return new ResponseEntity<String>("Usuario no encontrado.", HttpStatus.BAD_REQUEST);

			} else {
				usuarioService.deleteUsuarioById(id);
				return new ResponseEntity<String>("Usuario eliminado.", HttpStatus.OK);
			}
	}
	*/
	
	}