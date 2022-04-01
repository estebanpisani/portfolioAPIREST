package com.argprogr.portfolioweb.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {
	
	@Column(name = "id_persona")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column( nullable = false)
	private String nombre;
	@Column( nullable = false)
	private String apellido;
	private String direccion;
	private String email;
	@Lob
	private String descripcion;
	private String telefono;
	private String fechaNac;
	
	/* TODO Parsear fecha
	 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.parse(dto.getCreationDate(), formatter );
	 */
	
	private String repoURL;
	private String linkedInURL;
	private String websiteURL;
	@Lob
	private String fotoURL;
	
	@OneToMany(mappedBy = "persona", orphanRemoval = true)
	private List<Trabajo> trabajos = new ArrayList<Trabajo>();
	
	/*
	@OneToMany(mappedBy = "persona", orphanRemoval = true)
	private List<Educacion> formaciones = new ArrayList<Educacion>();
	@OneToMany(mappedBy = "persona", orphanRemoval = true)
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	*/
	
	

}
