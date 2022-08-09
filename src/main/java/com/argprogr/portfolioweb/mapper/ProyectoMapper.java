package com.argprogr.portfolioweb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.argprogr.portfolioweb.dto.ProyectoDTO;
import com.argprogr.portfolioweb.model.Proyecto;

@Component
public class ProyectoMapper {
	
	public ProyectoDTO Entity2DTO(Proyecto proyecto) {
		ProyectoDTO dto = new ProyectoDTO();
		
		dto.setId(proyecto.getId());
		dto.setNombreProyecto(proyecto.getNombreProyecto());
		dto.setDescripcion(proyecto.getDescripcion());
		dto.setWebsiteURL(proyecto.getWebsiteURL());
		dto.setRepoURL(proyecto.getRepoURL());
		return dto;
	}
	
	public Proyecto DTO2Entity(ProyectoDTO dto) {
		Proyecto proyecto = new Proyecto();
		
		proyecto.setNombreProyecto(dto.getNombreProyecto());
		proyecto.setDescripcion(dto.getDescripcion());
		proyecto.setWebsiteURL(dto.getWebsiteURL());
		proyecto.setRepoURL(dto.getRepoURL());
		return proyecto;				
	}

	public List<ProyectoDTO> EntityList2DTOList(List<Proyecto> proyectos) {
		List<ProyectoDTO> dtos = new ArrayList<ProyectoDTO>();
		
		for (Proyecto proyecto : proyectos) {
			ProyectoDTO dto = this.Entity2DTO(proyecto);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public List<Proyecto> DTOList2EntityList(List<ProyectoDTO> dtos) {
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		for (ProyectoDTO dto : dtos) {
			Proyecto proyecto = this.DTO2Entity(dto);
			proyectos.add(proyecto);
		}
		return proyectos;
	}
}
