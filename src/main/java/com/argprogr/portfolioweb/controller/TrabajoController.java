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

import com.argprogr.portfolioweb.model.Trabajo;
import com.argprogr.portfolioweb.service.TrabajoService;

@RestController
public class TrabajoController {
	
	@Autowired
	TrabajoService trabajoService;
	
	@GetMapping("/trabajo/list")
	public List<Trabajo> getTrabajos(){
		return trabajoService.getTrabajos();
	}
	
	@PostMapping("trabajo/{personaId}/save")
	public String saveTrabajo(@PathVariable Long personaId, @RequestBody Trabajo trabajo) {
		trabajoService.saveTrabajo(trabajo);
		return "Trabajo guardado.";
	}

	@PutMapping("trabajo/edit/{id}")
	public Trabajo updateTrabajo (@PathVariable Long id,
			@RequestBody Trabajo trabajo) {
		
		return trabajoService.updateTrabajo(id, trabajo);
	}
	
	@DeleteMapping("trabajo/delete/{id}")
	public String deleteTrabajo (@PathVariable Long id) {
		trabajoService.deleteTrabajo(id);
		return "Trabajo eliminado.";
	}
}
