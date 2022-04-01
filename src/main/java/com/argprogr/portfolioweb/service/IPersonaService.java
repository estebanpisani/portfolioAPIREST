package com.argprogr.portfolioweb.service;

import java.util.List;

import com.argprogr.portfolioweb.model.Persona;

public interface IPersonaService {
	
	public void savePersona (Persona persona);
	
	public Persona updatePersona(Long id, Persona persona);
	
	public List<Persona> getPersonas();
	
	public Persona findPersona (Long id);
	
	public void deletePersona (Long id);
	
}
