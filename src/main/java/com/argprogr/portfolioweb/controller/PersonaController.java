package com.argprogr.portfolioweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping("/persona/list")
	public List<Persona> getPersonas(){
		return personaService.getPersonas();
	}
	
	@PostMapping("persona/save")
	public String savePersona(@RequestBody Persona persona) {
		personaService.savePersona(persona);
		return "Persona guardada.";
	}

	@PutMapping("persona/edit/{id}")
	public Persona updatePersona (@PathVariable Long id,
			@RequestBody Persona persona) {
		
		return personaService.updatePersona(id, persona);
	}
	
	@DeleteMapping("persona/delete/{id}")
	public String deletePersona (@PathVariable Long id) {
		personaService.deletePersona(id);
		return "Persona eliminada.";
	}
	
}
