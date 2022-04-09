package com.argprogr.portfolioweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argprogr.portfolioweb.model.Rol;
import com.argprogr.portfolioweb.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
