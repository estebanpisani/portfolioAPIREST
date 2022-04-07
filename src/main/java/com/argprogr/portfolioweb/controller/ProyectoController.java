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

import com.argprogr.portfolioweb.dto.ProyectoDTO;
import com.argprogr.portfolioweb.model.Proyecto;
import com.argprogr.portfolioweb.service.ProyectoService;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {

	@Autowired
	ProyectoService proyectoService;
	
	@GetMapping("/list")
	public List<ProyectoDTO> getProyectos(){
		return proyectoService.getProyectos((long) 1);
	}
	
	@PostMapping("/save")
	public String saveProyecto(@RequestBody ProyectoDTO dto) {
		proyectoService.saveProyecto(dto, (long) 1);
		return "Proyecto guardado.";
	}

	@PutMapping("/edit/{id}")
	public String updateProyecto (@PathVariable Long id,
			@RequestBody ProyectoDTO dto) {
		proyectoService.updateProyecto(id, dto);
		return "Proyecto guardado.";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProyecto (@PathVariable Long id) {
		proyectoService.deleteProyecto(id);
		return "Proyecto eliminado.";
	}
}
