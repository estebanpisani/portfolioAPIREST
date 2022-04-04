package com.argprogr.portfolioweb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrabajoDTO {	
	private Long id;
	private String nombreEmpresa;
	private String puesto;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private String websiteURL;
}
