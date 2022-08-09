package com.argprogr.portfolioweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;

import com.argprogr.portfolioweb.dto.EducacionDTO;
import com.argprogr.portfolioweb.dto.Mensaje;
import com.argprogr.portfolioweb.dto.TrabajoDTO;
import com.argprogr.portfolioweb.service.EducacionService;

@RestController
@RequestMapping("/api/educacion")
@CrossOrigin(origins = "https://estebanpisaniportfolio.web.app")
public class EducacionController {
	
	@Autowired
	EducacionService educacionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<EducacionDTO> getEducacion(@PathVariable Long id){
		EducacionDTO dto = educacionService.findEducacion(id);	
		if(dto==null) {
			return new ResponseEntity(new Mensaje("Estudio no encontrado."), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(dto, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<EducacionDTO>> getEducaciones(){
		List<EducacionDTO> list = educacionService.getEducaciones((long) 1);
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("Aún no ha agregado estudios."), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveEducacion(@RequestBody EducacionDTO dto) {
        if(!StringUtils.hasText(dto.getNombreInstituto())) {
            return new ResponseEntity(
            		new Mensaje("El nombre del instituto es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if(!StringUtils.hasText(dto.getCurso())) {
            return new ResponseEntity(
            		new Mensaje("El nombre del curso es obligatorio."), HttpStatus.BAD_REQUEST);
            }   
        
		educacionService.saveEducacion(dto);
		return new ResponseEntity(new Mensaje("Estudio guardado."), HttpStatus.ACCEPTED);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateEducacion (@PathVariable Long id,
			@RequestBody EducacionDTO dto) {
		
        if(!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe en la base de datos."), HttpStatus.BAD_REQUEST);
            }
        
        if(!StringUtils.hasText(dto.getNombreInstituto())) {
            return new ResponseEntity(
            		new Mensaje("El nombre del instituto es obligatorio."), HttpStatus.BAD_REQUEST);
            }
        if(!StringUtils.hasText(dto.getCurso())) {
            return new ResponseEntity(
            		new Mensaje("El nombre del curso es obligatorio."), HttpStatus.BAD_REQUEST);
            } 

		educacionService.updateEducacion(id, dto);
		return new ResponseEntity(new Mensaje("Estudio actualizado."), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEducacion (@PathVariable Long id) {
        if(!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe en la base de datos."), HttpStatus.BAD_REQUEST);
            }
		educacionService.deleteEducacion(id);
		return new ResponseEntity(new Mensaje("Estudio eliminado."), HttpStatus.OK);
	}

}
