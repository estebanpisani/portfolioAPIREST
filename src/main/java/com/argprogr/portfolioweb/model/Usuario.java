package com.argprogr.portfolioweb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario")
	private Long id;
	private String username;
	private String pasword;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
	private Set<Rol> roles = new HashSet<Rol>();
}
