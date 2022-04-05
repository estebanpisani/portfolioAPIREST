package com.argprogr.portfolioweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argprogr.portfolioweb.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByUsername(String username);
	public Boolean existsByUsername(String username);
}
