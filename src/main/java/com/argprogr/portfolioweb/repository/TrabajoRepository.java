package com.argprogr.portfolioweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.model.Trabajo;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Long>{

	List<Trabajo> findByPersona(Persona persona);

}
