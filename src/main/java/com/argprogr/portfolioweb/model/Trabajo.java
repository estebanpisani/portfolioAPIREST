package com.argprogr.portfolioweb.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Trabajo {
	
	@Column(name = "id_trabajo")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column( nullable = false)
	private String nombreEmpresa;
	private String puesto;
	@Lob
	private String descripcion;
	/*
	 * TODO cambiar a LocalDate
	 */
	private String fechaInicio;
	private String fechaFin;
	private String websiteURL;
	/*
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_persona")
	private Persona persona;
	*/
	
}
