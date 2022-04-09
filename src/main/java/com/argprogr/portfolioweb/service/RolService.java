package com.argprogr.portfolioweb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.enums.RolNombre;
import com.argprogr.portfolioweb.model.Rol;
import com.argprogr.portfolioweb.repository.RolRepository;

@Service
public class RolService {
	@Autowired
	RolRepository rolRepo;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return rolRepo.findByRolNombre(rolNombre);
	}
	
	public void save (Rol rol) {
		rolRepo.save(rol);
	}

}
