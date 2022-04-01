package com.argprogr.portfolioweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.model.Trabajo;
import com.argprogr.portfolioweb.repository.TrabajoRepository;

@Service
public class TrabajoService implements ITrabajoService{

	@Autowired
	TrabajoRepository trabajoRepo;
	
	@Override
	public void saveTrabajo(Trabajo trabajo) {
		trabajoRepo.save(trabajo);
	}

	@Override
	public Trabajo updateTrabajo(Long id, Trabajo trabajo) {
		// TODO desarrollar updateTrabajo
		return null;

	}

	@Override
	public List<Trabajo> getTrabajos() {
		return trabajoRepo.findAll();
	}

	@Override
	public Trabajo findTrabajo(Long id) {
		return trabajoRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteTrabajo(Long id) {
		trabajoRepo.deleteById(id);
	}
	
	

}
