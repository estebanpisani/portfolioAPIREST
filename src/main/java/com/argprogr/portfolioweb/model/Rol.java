package com.argprogr.portfolioweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.argprogr.portfolioweb.enums.RolNombre;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long id;
	@Column(name = "nombre_rol")
    @Enumerated(EnumType.STRING)
	private RolNombre rolNombre;
	
	public Rol() {};
	
	public Rol(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}
	
	

}
