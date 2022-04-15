package com.argprogr.portfolioweb.mapper;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.argprogr.portfolioweb.dto.TrabajoDTO;
import com.argprogr.portfolioweb.model.Trabajo;

@Component
public class TrabajoMapper{

	public TrabajoDTO Entity2DTO(Trabajo trabajo) {
		
		TrabajoDTO dto = new TrabajoDTO();
		
		dto.setId(trabajo.getId());
		dto.setNombreEmpresa(trabajo.getNombreEmpresa());
		dto.setPuesto(trabajo.getPuesto());
		dto.setDescripcion(trabajo.getDescripcion());
		dto.setWebsiteURL(trabajo.getWebsiteURL());
		if(trabajo.getFechaInicio()!=null) {
			dto.setFechaInicio(trabajo.getFechaInicio().format(DateTimeFormatter.ofPattern("MM/yyyy")));			
		}
		if(trabajo.getFechaFin()!=null) {
			dto.setFechaFin(trabajo.getFechaFin().format(DateTimeFormatter.ofPattern("MM/yyyy")));			
		}			
		return dto;
	}
	
	public Trabajo DTO2Entity(TrabajoDTO dto) {
		
		Trabajo trabajo = new Trabajo();
		
		trabajo.setNombreEmpresa(dto.getNombreEmpresa());
		trabajo.setPuesto(dto.getPuesto());
		trabajo.setDescripcion(dto.getDescripcion());
		trabajo.setWebsiteURL(dto.getWebsiteURL());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(dto.getFechaInicio()!=null && !dto.getFechaInicio().isEmpty()) {
			//LocalDate inicio = YearMonth.parse(dto.getFechaInicio(), formatter).atDay(1);
			LocalDate inicio = LocalDate.parse(dto.getFechaInicio(), formatter );		
			trabajo.setFechaInicio(inicio);
		}
		if(dto.getFechaInicio()!=null && !dto.getFechaInicio().isEmpty()) {
			LocalDate fin = LocalDate.parse(dto.getFechaFin(), formatter );	
			trabajo.setFechaFin(fin);
		}
		return trabajo;
	}

	public List<TrabajoDTO> EntityList2DTOList(List<Trabajo> trabajos) {
		List<TrabajoDTO> dtos = new ArrayList<TrabajoDTO>();
		
		for (Trabajo trabajo : trabajos) {
			TrabajoDTO dto = this.Entity2DTO(trabajo);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public List<Trabajo> DTOList2EntityList(List<TrabajoDTO> dtos) {
		List<Trabajo> trabajos = new ArrayList<Trabajo>();
		
		for (TrabajoDTO dto : dtos) {
			Trabajo trabajo = this.DTO2Entity(dto);
			trabajos.add(trabajo);
		}
		return trabajos;
	}
	
	

}
