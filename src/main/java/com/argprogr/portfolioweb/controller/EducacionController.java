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

import com.argprogr.portfolioweb.dto.EducacionDTO;
import com.argprogr.portfolioweb.model.Educacion;
import com.argprogr.portfolioweb.service.EducacionService;

@RestController
@RequestMapping("/api/educacion/{idPersona}")
public class EducacionController {
	
	@Autowired
	EducacionService educacionService;
	
	@GetMapping("/list")
	public List<EducacionDTO> getEducaciones(){
		return educacionService.getEducaciones((long) 1);
	}
	
	@PostMapping("/save")
	public String saveEducacion(@RequestBody EducacionDTO dto) {
		educacionService.saveEducacion(dto, (long) 1);
		return "Educacion guardada.";
	}

	@PutMapping("/edit/{id}")
	public String updateEducacion (@PathVariable Long id,
			@RequestBody EducacionDTO dto) {
		educacionService.updateEducacion(id, dto);
		return "Educacion guardada.";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEducacion (@PathVariable Long id) {
		educacionService.deleteEducacion(id);
		return "Educacion eliminada.";
	}

}
