package com.argprogr.portfolioweb.dto;

import lombok.Data;

@Data
public class EducacionDTO {
	private Long id;
	private String nombreInstituto;
	private String curso;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private String websiteURL;
}
