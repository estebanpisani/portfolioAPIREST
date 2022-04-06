package com.argprogr.portfolioweb.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.dto.UserDTO;
import com.argprogr.portfolioweb.model.Rol;
import com.argprogr.portfolioweb.model.Usuario;
import com.argprogr.portfolioweb.repository.RolRepository;
import com.argprogr.portfolioweb.repository.UsuarioRepository;

@Service
public class UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepo;
	@Autowired
	RolRepository rolRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	/*
	 * TODO CRUD Usuario.
	 */
	
	public void saveUsuario(UserDTO dto, boolean admin) {
		
		Usuario usuario = new Usuario();
		usuario.setUsername(dto.getUsername());
		usuario.setPasword(passwordEncoder.encode(dto.getPassword()));
		
		if(admin) {
			Rol rol = rolRepo.findByNombre("ROLE_ADMIN").get();
			usuario.setRoles(Collections.singleton(rol));
		} else {
			Rol rol = rolRepo.findByNombre("ROLE_USER").get();
			usuario.setRoles(Collections.singleton(rol));			
		}
		System.out.println("Usuario creado con rol "+ usuario.getRoles().toString());
		usuarioRepo.save(usuario);
	}

	public void deleteUsuarioById(Long id) {
		usuarioRepo.deleteById(id);
	}

}
