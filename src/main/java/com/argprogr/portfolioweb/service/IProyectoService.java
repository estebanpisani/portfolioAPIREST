package com.argprogr.portfolioweb.service;

import java.util.List;

import com.argprogr.portfolioweb.model.Proyecto;

public interface IProyectoService {
	

	
	public void saveProyecto (Proyecto proyecto);
	
	public Proyecto updateProyecto(Long id, Proyecto proyecto);
	
	public List<Proyecto> getProyectos();
	
	public Proyecto findProyecto (Long id);
	
	public void deleteProyecto (Long id);

}
