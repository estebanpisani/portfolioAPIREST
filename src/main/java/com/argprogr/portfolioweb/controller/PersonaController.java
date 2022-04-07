package com.argprogr.portfolioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping()
	public PersonaDTO getPersona(){
		return personaService.findPersona((long) 1);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("/save")
	public String savePersona(@RequestBody PersonaDTO dto) {
		personaService.savePersona(dto);
		return "Persona creada.";
	}

	@PutMapping("/edit")
	public String updatePersona (@RequestBody PersonaDTO dto) {
		personaService.updatePersona((long) 1, dto);
		return "Persona editada";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public String deletePersona (@PathVariable Long id) {
		personaService.deletePersona(id);
		return "Persona eliminada.";
	}

}
