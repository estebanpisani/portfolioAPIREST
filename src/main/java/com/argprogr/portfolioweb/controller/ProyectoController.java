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
import com.argprogr.portfolioweb.dto.ProyectoDTO;
import com.argprogr.portfolioweb.service.ProyectoService;

@RestController
@RequestMapping("/api/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {

	@Autowired
	ProyectoService proyectoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<ProyectoDTO>> getProyectos(){
		List<ProyectoDTO> list = proyectoService.getProyectos((long) 1);
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("Aún no ha agregado proyectos."), HttpStatus.OK);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveProyecto(@RequestBody ProyectoDTO dto) {
		
        if(!StringUtils.hasText(dto.getNombreProyecto())) {
            return new ResponseEntity(
            		new Mensaje("El nombre del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
            }   
        
        proyectoService.saveProyecto(dto, (long) 1);
		return new ResponseEntity(new String("Proyecto guardado."), HttpStatus.CREATED);

	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateProyecto (@PathVariable Long id,
			@RequestBody ProyectoDTO dto) {
        if(!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe en la base de datos."), HttpStatus.NOT_FOUND);
            }
        if(!StringUtils.hasText(dto.getNombreProyecto())) {
            return new ResponseEntity(
            		new Mensaje("El nombre del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
            } 		
		
		proyectoService.updateProyecto(id, dto);
		return new ResponseEntity(new String("Proyecto actualizado."), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProyecto (@PathVariable Long id) {
        if(!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe en la base de datos."), HttpStatus.NOT_FOUND);
            }
		proyectoService.deleteProyecto(id);
		return new ResponseEntity("Proyecto eliminado.", HttpStatus.OK);
	}
}
