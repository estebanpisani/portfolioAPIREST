package com.argprogr.portfolioweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprogr.portfolioweb.dto.PersonaDTO;
import com.argprogr.portfolioweb.service.PersonaService;
import com.argprogr.portfolioweb.service.TrabajoService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	@Autowired
	TrabajoService trabajoService;
	
	@GetMapping("/list")
	public List<PersonaDTO> getPersonas(){
		return personaService.getPersonas();
	}
	
	@PostMapping("/save")
	public String savePersona(@RequestBody PersonaDTO dto) {
		personaService.savePersona(dto);
		return "Persona creada";
	}

	@PutMapping("/edit/{id}")
	public String updatePersona (@PathVariable Long id,
			@RequestBody PersonaDTO dto) {
		personaService.updatePersona(id, dto);
		return "Persona editada";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePersona (@PathVariable Long id) {
		personaService.deletePersona(id);
		return "Persona eliminada.";
	}

}
