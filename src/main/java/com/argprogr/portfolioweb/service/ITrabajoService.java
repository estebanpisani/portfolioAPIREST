package com.argprogr.portfolioweb.service;

import java.util.List;

import com.argprogr.portfolioweb.model.Trabajo;

public interface ITrabajoService {
	
	public void saveTrabajo (Trabajo trabajo);
	
	public Trabajo updateTrabajo(Long id, Trabajo trabajo);
	
	public List<Trabajo> getTrabajos();
	
	public Trabajo findTrabajo (Long id);
	
	public void deleteTrabajo (Long id);
	
}
