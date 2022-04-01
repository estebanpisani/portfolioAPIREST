package com.argprogr.portfolioweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {
	@Autowired
	PersonaRepository personaRepo;


	@Override
	public void savePersona(Persona persona) {
		
		personaRepo.save(persona);
		
	}

	@Override
	public Persona updatePersona(Long id, Persona persona) {
		
		Persona perso = personaRepo.getById(id);
		
		perso.setNombre(persona.getNombre());
		perso.setApellido(persona.getApellido());
		perso.setDescripcion(persona.getDescripcion());
		perso.setDireccion(persona.getDireccion());
		perso.setTelefono(persona.getTelefono());
		perso.setEmail(persona.getEmail());
		perso.setLinkedInURL(persona.getLinkedInURL());
		perso.setRepoURL(persona.getRepoURL());
		perso.setWebsiteURL(persona.getWebsiteURL());
		
		return personaRepo.save(perso);
	}

	@Override
	public List<Persona> getPersonas() {
		
		return personaRepo.findAll();
	}
	
	@Override
	public Persona findPersona(Long id) {

		return personaRepo.findById(id).orElse(null);
	}
	
	@Override
	public void deletePersona(Long id) {

		personaRepo.deleteById(id);
	}



}
