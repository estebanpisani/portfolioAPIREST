package com.argprogr.portfolioweb.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.dto.TrabajoDTO;
import com.argprogr.portfolioweb.mapper.TrabajoMapper;
import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.model.Trabajo;
import com.argprogr.portfolioweb.repository.PersonaRepository;
import com.argprogr.portfolioweb.repository.TrabajoRepository;

@Service
public class TrabajoService{

	@Autowired
	TrabajoRepository trabajoRepo;
	@Autowired
	TrabajoMapper mapper;
	@Autowired
	PersonaRepository personaRepo;
	
	public void saveTrabajo(TrabajoDTO dto, Long idPersona) {
		Trabajo trabajo = mapper.DTO2Entity(dto);
		Persona persona = personaRepo.getById(idPersona);
		trabajo.setPersona(persona);
		persona.getTrabajos().add(trabajo);
		trabajoRepo.save(trabajo);
	}

	public void updateTrabajo(Long id, TrabajoDTO dto) {
		
		Trabajo trabajo = trabajoRepo.getById(id);
		
		trabajo.setNombreEmpresa(dto.getNombreEmpresa());
		trabajo.setPuesto(dto.getPuesto());
		trabajo.setDescripcion(dto.getDescripcion());
		trabajo.setWebsiteURL(dto.getWebsiteURL());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate inicio = LocalDate.parse(dto.getFechaInicio(), formatter );
		LocalDate fin = LocalDate.parse(dto.getFechaFin(), formatter );
		trabajo.setFechaInicio(inicio);
		trabajo.setFechaFin(fin);
		
		trabajoRepo.save(trabajo);
	}

	public List<TrabajoDTO> getTrabajosById(Long id) {
		
		return mapper.EntityList2DTOList(trabajoRepo.findByPersona(personaRepo.getById(id)));
	}

	public TrabajoDTO findTrabajo(Long id) {
		Trabajo trabajo = trabajoRepo.findById(id).orElse(null);
		if(trabajo!=null) {
		return mapper.Entity2DTO(trabajo);
		}
		return null;
	}

	public Boolean existsById(Long id) {
		return trabajoRepo.existsById(id);
	}
	
	public void deleteTrabajo(Long id) {
		trabajoRepo.deleteById(id);
	}
	
	

}
