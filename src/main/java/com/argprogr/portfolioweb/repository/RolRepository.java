package com.argprogr.portfolioweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argprogr.portfolioweb.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
	public Optional<Rol> findByNombre(String nombre);

}
