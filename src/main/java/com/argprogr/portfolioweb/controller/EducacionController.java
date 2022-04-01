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

import com.argprogr.portfolioweb.model.Educacion;
import com.argprogr.portfolioweb.service.EducacionService;

@RestController
public class EducacionController {
	
	@Autowired
	EducacionService educacionService;
	
	@GetMapping("/educacion/list")
	public List<Educacion> getEducacions(){
		return educacionService.getEducacions();
	}
	
	@PostMapping("educacion/save")
	public String saveEducacion(@RequestBody Educacion educacion) {
		educacionService.saveEducacion(educacion);
		return "Educacion guardada.";
	}

	@PutMapping("educacion/edit/{id}")
	public Educacion updateEducacion (@PathVariable Long id,
			@RequestBody Educacion educacion) {
		
		return educacionService.updateEducacion(id, educacion);
	}
	
	@DeleteMapping("educacion/delete/{id}")
	public String deleteEducacion (@PathVariable Long id) {
		educacionService.deleteEducacion(id);
		return "Educacion eliminada.";
	}

}
