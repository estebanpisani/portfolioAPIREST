package com.argprogr.portfolioweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprogr.portfolioweb.dto.EducacionDTO;
import com.argprogr.portfolioweb.service.EducacionService;

@RestController
@RequestMapping("/api/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
	
	@Autowired
	EducacionService educacionService;
	
	@GetMapping("/list")
	public List<EducacionDTO> getEducaciones(){
		return educacionService.getEducaciones((long) 1);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveEducacion(@RequestBody EducacionDTO dto) {
		educacionService.saveEducacion(dto, (long) 1);
		return new ResponseEntity(new String("Educacion guardada"), HttpStatus.CREATED);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateEducacion (@PathVariable Long id,
			@RequestBody EducacionDTO dto) {
		educacionService.updateEducacion(id, dto);
		return new ResponseEntity(new String("Educacion guardada"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEducacion (@PathVariable Long id) {
		System.out.println("Borrando id "+id+"...");
		educacionService.deleteEducacion(id);
		return new ResponseEntity(new String("Educacion eliminada"), HttpStatus.OK);
	}

}
