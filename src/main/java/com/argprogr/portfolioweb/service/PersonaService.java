package com.argprogr.portfolioweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.dto.PersonaDTO;
import com.argprogr.portfolioweb.mapper.PersonaMapper;
import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.repository.PersonaRepository;

@Service
public class PersonaService{
	@Autowired
	PersonaRepository personaRepo;
	@Autowired
	PersonaMapper mapper;

	public void savePersona(PersonaDTO dto) {
		
		personaRepo.save(mapper.DTO2Entity(dto));
		
	}

	public void updatePersona(Long id, PersonaDTO dto) {
		
		Persona persona = personaRepo.getById(id);
		
		persona.setNombre(dto.getNombre());
		persona.setApellido(dto.getApellido());
		persona.setDescripcion(dto.getDescripcion());
		persona.setDireccion(dto.getDireccion());
		persona.setTelefono(dto.getTelefono());
		persona.setEmail(dto.getEmail());
		persona.setLinkedInURL(dto.getLinkedInURL());
		persona.setRepoURL(dto.getRepoURL());
		persona.setWebsiteURL(dto.getWebsiteURL());
		personaRepo.save(persona);
	}

	public List<PersonaDTO> getPersonas() {
		
		return mapper.EntityList2DTOList(personaRepo.findAll());
	}
	
	public PersonaDTO findPersona(Long id) {
		Persona persona = personaRepo.findById(id).orElse(null);
		if (persona != null) {
			return mapper.Entity2DTO(persona);
		}
		return null;
	}
	
	public void deletePersona(Long id) {

		personaRepo.deleteById(id);
	}



}
