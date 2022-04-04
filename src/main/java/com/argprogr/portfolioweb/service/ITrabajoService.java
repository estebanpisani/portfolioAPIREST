package com.argprogr.portfolioweb.service;

import java.util.List;

import com.argprogr.portfolioweb.dto.TrabajoDTO;
import com.argprogr.portfolioweb.model.Trabajo;

public interface ITrabajoService {
	
	public Trabajo saveTrabajo (TrabajoDTO dto);
	
	public void updateTrabajo(Long id, TrabajoDTO dto);
	
	public List<TrabajoDTO> getTrabajos();
	
	public TrabajoDTO findTrabajo (Long id);
	
	public void deleteTrabajo (Long id);
	
}
