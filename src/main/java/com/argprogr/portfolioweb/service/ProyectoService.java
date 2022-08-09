package com.argprogr.portfolioweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.dto.ProyectoDTO;
import com.argprogr.portfolioweb.mapper.ProyectoMapper;
import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.model.Proyecto;
import com.argprogr.portfolioweb.repository.PersonaRepository;
import com.argprogr.portfolioweb.repository.ProyectoRepository;

@Service
public class ProyectoService{
	
	@Autowired
	ProyectoRepository proyectoRepo;
	@Autowired
	ProyectoMapper mapper;
	@Autowired
	PersonaRepository personaRepo;

	public void saveProyecto(ProyectoDTO dto, Long idPersona) {
		Proyecto proyecto = mapper.DTO2Entity(dto);
		Persona persona = personaRepo.getById(idPersona);
		proyecto.setPersona(persona);
		persona.getProyectos().add(proyecto);
		proyectoRepo.save(proyecto);		
	}

	public void updateProyecto(Long id, ProyectoDTO dto) {
		Proyecto proyecto = proyectoRepo.getById(id);
		proyecto.setNombreProyecto(dto.getNombreProyecto());
		proyecto.setDescripcion(dto.getDescripcion());
		proyecto.setWebsiteURL(dto.getWebsiteURL());
		proyecto.setRepoURL(dto.getRepoURL());
		proyectoRepo.save(proyecto);	
	}


	public List<ProyectoDTO> getProyectos(Long id) {
		return mapper.EntityList2DTOList(proyectoRepo.findByPersona(personaRepo.getById(id)));
	}

	public ProyectoDTO findProyecto(Long id) {		
		return mapper.Entity2DTO(proyectoRepo.findById(id).orElse(null));
	}
	
	public Boolean existsById(Long id) {
		return proyectoRepo.existsById(id);
	}

	public void deleteProyecto(Long id) {
		proyectoRepo.deleteById(id);
	}

}
