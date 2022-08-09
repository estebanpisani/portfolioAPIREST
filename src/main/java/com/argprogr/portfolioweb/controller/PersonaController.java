package com.argprogr.portfolioweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprogr.portfolioweb.dto.Mensaje;
import com.argprogr.portfolioweb.dto.PersonaDTO;
import com.argprogr.portfolioweb.service.PersonaService;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "https://estebanpisaniportfolio.web.app")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping()
	public ResponseEntity<PersonaDTO> getPersona(){
		PersonaDTO dto = personaService.findPersona((long) 1);
		if (dto!=null) {
			return new ResponseEntity(dto, HttpStatus.OK);
		}else {
			return new ResponseEntity(dto, HttpStatus.BAD_REQUEST);
		}
		
	}
	/*
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("/save")
	public String savePersona(@RequestBody PersonaDTO dto) {
		personaService.savePersona(dto);
		return "Persona creada.";
	}
	*/
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")	
	@PutMapping("/edit")
	public ResponseEntity<?> updatePersona (@RequestBody PersonaDTO dto) {
	      if(!StringUtils.hasText(dto.getNombre())) {
	            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        }
	      if(!StringUtils.hasText(dto.getApellido())) {
	            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
	        }
	      
		personaService.updatePersona((long) 1, dto);
		return new ResponseEntity(new Mensaje("Persona editada"), HttpStatus.OK);
	}
	
	
	
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePersona (@PathVariable Long id) {
        if(!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe en la base de datos."), HttpStatus.NOT_FOUND);
            }
		personaService.deletePersona(id);
		return new ResponseEntity("Persona eliminada.", HttpStatus.OK);
	}

}
