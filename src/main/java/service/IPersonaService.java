package service;

import java.util.List;

import model.Persona;

public interface IPersonaService {
	
	public void savePersona (Persona persona);
	
	public void updatePersona(Long id, Persona persona);
	
	public List<Persona> getPersonas();
	
	public Persona findPersona (Long id);
	
	public void deletePersona (Long id);
	
}
