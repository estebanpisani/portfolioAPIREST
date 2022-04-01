package com.argprogr.portfolioweb.service;

import java.util.List;

import com.argprogr.portfolioweb.model.Educacion;

public interface IEducacionService {
	
	public void saveEducacion (Educacion educacion);
	
	public Educacion updateEducacion(Long id, Educacion educacion);
	
	public List<Educacion> getEducacions();
	
	public Educacion findPersona (Long id);
	
	public void deleteEducacion (Long id);
}
