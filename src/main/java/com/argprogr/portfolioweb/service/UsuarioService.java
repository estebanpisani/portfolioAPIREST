package com.argprogr.portfolioweb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.model.Usuario;
import com.argprogr.portfolioweb.repository.UsuarioRepository;

@Service
public class UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepo;

	public void saveUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);
	}
	
	public Optional<Usuario> getByUsername(String username) {
		return usuarioRepo.findByUsername(username);
	}
	
	public Boolean existsById(Long id) {
		return usuarioRepo.existsById(id);
	}

	public void deleteUsuarioById(Long id) {
		usuarioRepo.deleteById(id);
	}

}
