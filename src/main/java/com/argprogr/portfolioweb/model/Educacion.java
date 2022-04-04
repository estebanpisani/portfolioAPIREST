package com.argprogr.portfolioweb.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Educacion {
	
	@Column(name = "id_educacion")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column( nullable = false)
	private String nombreInstituto;
	@Column( nullable = false)
	private String curso;
	@Lob
	private String descripcion;

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String websiteURL;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_persona")
	private Persona persona;

}
