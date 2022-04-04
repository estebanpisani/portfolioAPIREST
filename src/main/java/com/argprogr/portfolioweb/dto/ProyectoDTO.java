package com.argprogr.portfolioweb.dto;

import lombok.Data;

@Data
public class ProyectoDTO {
	private Long id;
	private String nombreProyecto;
	private String descripcion;
	private String websiteURL;
}
