package com.argprogr.portfolioweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long id;
	@Column(name = "nombre_rol")
	private String nombre;
	/*
	@OneToMany(mappedBy = "rol", orphanRemoval = false)
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	*/
}
