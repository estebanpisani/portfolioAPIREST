package com.argprogr.portfolioweb.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argprogr.portfolioweb.dto.EducacionDTO;
import com.argprogr.portfolioweb.mapper.EducacionMapper;
import com.argprogr.portfolioweb.model.Educacion;
import com.argprogr.portfolioweb.model.Persona;
import com.argprogr.portfolioweb.model.Trabajo;
import com.argprogr.portfolioweb.repository.EducacionRepository;
import com.argprogr.portfolioweb.repository.PersonaRepository;

@Service
public class EducacionService{
	
	@Autowired
	EducacionRepository educacionRepo;
	@Autowired
	EducacionMapper mapper;
	@Autowired
	PersonaRepository personaRepo;

public void saveEducacion(EducacionDTO dto, Long idPersona) {
	Educacion educacion = mapper.DTO2Entity(dto);
	Persona persona = personaRepo.getById(idPersona);
	educacion.setPersona(persona);
	persona.getFormaciones().add(educacion);
	educacionRepo.save(educacion);
}

public void updateEducacion(Long id, EducacionDTO dto) {
	Educacion educacion = educacionRepo.getById(id);
	
	educacion.setNombreInstituto(dto.getNombreInstituto());
	educacion.setCurso(dto.getCurso());
	educacion.setDescripcion(dto.getDescripcion());
	educacion.setWebsiteURL(dto.getWebsiteURL());
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate inicio = LocalDate.parse(dto.getFechaInicio(), formatter );
	LocalDate fin = LocalDate.parse(dto.getFechaFin(), formatter );
	educacion.setFechaInicio(inicio);
	educacion.setFechaFin(fin);
	
	educacionRepo.save(educacion);
}

public List<EducacionDTO> getEducaciones(Long id) {
	return mapper.EntityList2DTOList(educacionRepo.findByPersona(personaRepo.getById(id)));
}

public Educacion findPersona(Long id) {
	return educacionRepo.findById(id).orElse(null);
}

public void deleteEducacion(Long id) {
	educacionRepo.deleteById(id);
}

}
