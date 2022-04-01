package com.argprogr.portfolioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argprogr.portfolioweb.model.Educacion;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {

}
