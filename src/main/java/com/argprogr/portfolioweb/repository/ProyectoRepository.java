package com.argprogr.portfolioweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.model.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{

	List<Proyecto> findByPersona(Persona byId);

}
