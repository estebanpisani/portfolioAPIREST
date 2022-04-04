package com.argprogr.portfolioweb.service;

import java.util.List;

import com.argprogr.portfolioweb.dto.PersonaDTO;

public interface IPersonaService {
	
	public void savePersona (PersonaDTO dto);
	
	public void updatePersona(Long id, PersonaDTO dto);
	
	public List<PersonaDTO> getPersonas();
	
	public PersonaDTO findPersona (Long id);
	
	public void deletePersona (Long id);
	
}
