package com.argprogr.portfolioweb.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.argprogr.portfolioweb.dto.EducacionDTO;
import com.argprogr.portfolioweb.model.Educacion;

@Component
public class EducacionMapper {
	
	public EducacionDTO Entity2DTO(Educacion educacion) {
		
		EducacionDTO dto = new EducacionDTO();
		
		dto.setId(educacion.getId());
		dto.setNombreInstituto(educacion.getNombreInstituto());
		dto.setCurso(educacion.getCurso());
		dto.setFechaInicio(educacion.getFechaInicio().toString());
		dto.setFechaFin(educacion.getFechaFin().toString());
		dto.setWebsiteURL(educacion.getWebsiteURL());
		return dto;		
	}

	public Educacion DTO2Entity(EducacionDTO dto) {
		
		Educacion educacion = new Educacion();
		
		educacion.setId(dto.getId());
		educacion.setNombreInstituto(dto.getNombreInstituto());
		educacion.setDescripcion(dto.getDescripcion());
		educacion.setCurso(dto.getCurso());
		educacion.setWebsiteURL(dto.getWebsiteURL());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate inicio = LocalDate.parse(dto.getFechaInicio(), formatter );
		LocalDate fin = LocalDate.parse(dto.getFechaFin(), formatter );
		educacion.setFechaInicio(inicio);
		educacion.setFechaFin(fin);
		return educacion;	
	}
	
	public List<EducacionDTO> EntityList2DTOList(List<Educacion> educaciones) {
		List<EducacionDTO> dtos = new ArrayList<EducacionDTO>();
		
		for (Educacion educacion : educaciones) {
			EducacionDTO dto = this.Entity2DTO(educacion);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public List<Educacion> DTOList2EntityList(List<EducacionDTO> dtos) {
		List<Educacion> educaciones = new ArrayList<Educacion>();
		
		for (EducacionDTO dto : dtos) {
			Educacion educacion = this.DTO2Entity(dto);
			educaciones.add(educacion);
		}
		return educaciones;
	}
}
