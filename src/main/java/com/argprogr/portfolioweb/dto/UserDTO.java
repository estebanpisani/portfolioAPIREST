package com.argprogr.portfolioweb.dto;

import com.argprogr.portfolioweb.model.Rol;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
	
	private String username;
	private String password;
	private Set<Rol> roles;

}
