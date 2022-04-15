package com.argprogr.portfolioweb.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.argprogr.portfolioweb.dto.PersonaDTO;
import com.argprogr.portfolioweb.model.Persona;

@Component
public class PersonaMapper {
	
	
	public PersonaDTO Entity2DTO(Persona persona) {
		
		PersonaDTO dto = new PersonaDTO();
		
		dto.setId(persona.getId());
		dto.setNombre(persona.getNombre());
		dto.setApellido(persona.getApellido());
		dto.setDireccion(persona.getDireccion());
		dto.setEmail(persona.getEmail());
		dto.setDescripcion(persona.getDescripcion());
		dto.setTelefono(persona.getTelefono());
		dto.setCiudad(persona.getCiudad());
		dto.setPais(persona.getPais());
		dto.setFechaNac(persona.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		dto.setRepoURL(persona.getRepoURL());
		dto.setLinkedInURL(persona.getLinkedInURL());
		dto.setWebsiteURL(persona.getWebsiteURL());
		dto.setFotoURL(persona.getFotoURL());
		return dto;
	}

	public Persona DTO2Entity(PersonaDTO dto) {
		
		Persona persona = new Persona();
		
		persona.setNombre(dto.getNombre());
		persona.setApellido(dto.getApellido());
		persona.setDireccion(dto.getDireccion());
		persona.setEmail(dto.getEmail());
		persona.setDescripcion(dto.getDescripcion());
		persona.setTelefono(dto.getTelefono());
		persona.setCiudad(dto.getCiudad());
		persona.setPais(dto.getPais());
		persona.setRepoURL(dto.getRepoURL());
		persona.setLinkedInURL(dto.getLinkedInURL());
		persona.setFotoURL(dto.getFotoURL());
		if (dto.getFechaNac()!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.parse(dto.getFechaNac(), formatter );
			persona.setFechaNac(localDate);
		}
		return persona;
	}
	
	public List<PersonaDTO> EntityList2DTOList (List<Persona> personas) {
		
		List<PersonaDTO> dtos = new ArrayList<PersonaDTO>();
		
		for (Persona persona : personas) {
			PersonaDTO dto = this.Entity2DTO(persona);
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public List<Persona> DTOList2EntityList (List<PersonaDTO> dtos){
		List<Persona> personas = new ArrayList<Persona>();
		
		for (PersonaDTO dto : dtos) {
			Persona persona = this.DTO2Entity(dto);
			personas.add(persona);
		}
		return personas;
	}
	
}
