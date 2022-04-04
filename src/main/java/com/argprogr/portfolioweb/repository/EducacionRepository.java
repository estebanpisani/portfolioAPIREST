package com.argprogr.portfolioweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argprogr.portfolioweb.model.Educacion;
import com.argprogr.portfolioweb.model.Persona;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {

	List<Educacion> findByPersona(Persona byId);

}
