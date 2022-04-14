package com.argprogr.portfolioweb.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argprogr.portfolioweb.dto.PersonaDTO;
import com.argprogr.portfolioweb.mapper.PersonaMapper;
import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService{
	@Autowired
	PersonaRepository personaRepo;
	@Autowired
	PersonaMapper mapper;

	public Persona savePersona(PersonaDTO dto) {
		
		return personaRepo.save(mapper.DTO2Entity(dto));
	}

	public void updatePersona(Long id, PersonaDTO dto) {
		
		Persona persona = personaRepo.getById(id);
		
		persona.setNombre(dto.getNombre());
		persona.setApellido(dto.getApellido());
		persona.setDescripcion(dto.getDescripcion());
		persona.setDireccion(dto.getDireccion());
		persona.setTelefono(dto.getTelefono());
		persona.setCiudad(dto.getCiudad());
		persona.setPais(dto.getPais());
		persona.setEmail(dto.getEmail());
		persona.setLinkedInURL(dto.getLinkedInURL());
		persona.setRepoURL(dto.getRepoURL());
		persona.setWebsiteURL(dto.getWebsiteURL());
		persona.setFotoURL(dto.getFotoURL());
		if (dto.getFechaNac()!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.parse(dto.getFechaNac(), formatter );
			persona.setFechaNac(localDate);
		}
		personaRepo.save(persona);
	}
	
	public PersonaDTO findPersona(Long id) {
		Persona persona = personaRepo.findById(id).orElse(null);
		if (persona != null) {
			return mapper.Entity2DTO(persona);
		}
		return null;
	}
	
	public Boolean existsById(Long id) {
		return personaRepo.existsById(id);
	}
	
	public void deletePersona(Long id) {

		personaRepo.deleteById(id);
	}



}
