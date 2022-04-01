package com.argprogr.portfolioweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.model.Proyecto;
import com.argprogr.portfolioweb.repository.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService {
	
	@Autowired
	ProyectoRepository proyectoRepo;

	@Override
	public void saveProyecto(Proyecto proyecto) {
		proyectoRepo.save(proyecto);		
	}

	@Override
	public Proyecto updateProyecto(Long id, Proyecto proyecto) {
		// TODO updateProyecto
		return null;
	}

	@Override
	public List<Proyecto> getProyectos() {
		return proyectoRepo.findAll();
	}

	@Override
	public Proyecto findProyecto(Long id) {
		return proyectoRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteProyecto(Long id) {
		proyectoRepo.deleteById(id);
	}
	
	

}
