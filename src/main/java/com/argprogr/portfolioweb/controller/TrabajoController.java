package com.argprogr.portfolioweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.argprogr.portfolioweb.dto.TrabajoDTO;
import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.model.Trabajo;
import com.argprogr.portfolioweb.repository.PersonaRepository;
import com.argprogr.portfolioweb.service.PersonaService;
import com.argprogr.portfolioweb.service.TrabajoService;

@RestController
@RequestMapping("/api/trabajo")
@CrossOrigin(origins = "http://localhost:4200")
public class TrabajoController {
	
	@Autowired
	TrabajoService trabajoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<TrabajoDTO>> getTrabajos(){
		List<TrabajoDTO> list = trabajoService.getTrabajosById((long) 1);
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("Aún no ha agregado experiencias laborales."), HttpStatus.OK);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveTrabajo(@RequestBody TrabajoDTO dto) {
        if(!StringUtils.hasText(dto.getNombreEmpresa())) {
            return new ResponseEntity(
            		new Mensaje("Ingrese el nombre de la empresa o lugar de trabajo"), HttpStatus.BAD_REQUEST);
            }
		trabajoService.saveTrabajo(dto, (long) 1);
		return new ResponseEntity(new Mensaje("Trabajo guardado."), HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateTrabajo (@PathVariable Long id,
			@RequestBody TrabajoDTO dto) {
        if(!trabajoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe en la base de datos."), HttpStatus.NOT_FOUND);
            }
        if(!StringUtils.hasText(dto.getNombreEmpresa())) {
            return new ResponseEntity(
            		new Mensaje("Ingrese el nombre de la empresa o lugar de trabajo"), HttpStatus.BAD_REQUEST);
            }        
		trabajoService.updateTrabajo(id, dto);
		return new ResponseEntity(new Mensaje("Trabajo actualizado."),HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTrabajo (@PathVariable Long id) {
        if(!trabajoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe en la base de datos."), HttpStatus.NOT_FOUND);
            }
		trabajoService.deleteTrabajo(id);
		return new ResponseEntity("Trabajo eliminado.", HttpStatus.OK);
	}
}
