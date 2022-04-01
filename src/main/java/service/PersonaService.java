package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Persona;
import repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {
	@Autowired
	PersonaRepository personaRepo;


	@Override
	public void savePersona(Persona persona) {
		
		personaRepo.save(persona);
		
	}

	@Override
	public void updatePersona(Long id, Persona persona) {
		
		Persona perso = persona;
		perso.setId(id);
		personaRepo.save(perso);
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
