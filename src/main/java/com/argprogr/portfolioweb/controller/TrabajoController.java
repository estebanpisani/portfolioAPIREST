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

import com.argprogr.portfolioweb.dto.TrabajoDTO;
import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.model.Trabajo;
import com.argprogr.portfolioweb.repository.PersonaRepository;
import com.argprogr.portfolioweb.service.PersonaService;
import com.argprogr.portfolioweb.service.TrabajoService;

@RestController
@RequestMapping("{idPersona}/trabajo")
public class TrabajoController {
	
	@Autowired
	TrabajoService trabajoService;
	
	@GetMapping("/list")
	public List<TrabajoDTO> getTrabajos(@PathVariable Long idPersona){
		return trabajoService.getTrabajosById(idPersona);
	}
	
	@PostMapping("/save")
	public String saveTrabajo(@RequestBody TrabajoDTO dto, @PathVariable Long idPersona) {
		trabajoService.saveTrabajo(dto, idPersona);
		return "Trabajo guardado.";
	}

	@PutMapping("/edit/{id}")
	public void updateTrabajo (@PathVariable Long id,
			@RequestBody TrabajoDTO dto) {
		trabajoService.updateTrabajo(id, dto);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTrabajo (@PathVariable Long id) {
		trabajoService.deleteTrabajo(id);
		return "Trabajo eliminado.";
	}
}
