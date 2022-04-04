package com.argprogr.portfolioweb.dto;

import java.util.List;

import com.argprogr.portfolioweb.model.Trabajo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaDTO {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String email;
	private String descripcion;
	private String telefono;
	private String fechaNac;
	private String repoURL;
	private String linkedInURL;
	private String websiteURL;
	private String fotoURL;
	
}
