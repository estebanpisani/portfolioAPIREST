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

import com.argprogr.portfolioweb.model.Proyecto;
import com.argprogr.portfolioweb.service.ProyectoService;

@RestController
public class ProyectoController {

	@Autowired
	ProyectoService proyectoService;
	
	@GetMapping("/proyecto/list")
	public List<Proyecto> getProyectos(){
		return proyectoService.getProyectos();
	}
	
	@PostMapping("proyecto/save")
	public String saveProyecto(@RequestBody Proyecto proyecto) {
		proyectoService.saveProyecto(proyecto);
		return "Proyecto guardado.";
	}

	@PutMapping("/proyecto/edit/{id}")
	public Proyecto updateProyecto (@PathVariable Long id,
			@RequestBody Proyecto proyecto) {
		
		return proyectoService.updateProyecto(id, proyecto);
	}
	
	@DeleteMapping("proyecto/delete/{id}")
	public String deleteProyecto (@PathVariable Long id) {
		proyectoService.deleteProyecto(id);
		return "Proyecto eliminado.";
	}
}
