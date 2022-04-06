package com.argprogr.portfolioweb.security;

import lombok.Data;

@Data
public class JWTAuthResponseDTO {

	private String accesToken;
	private String tokenType = "Bearer ";
	
	public JWTAuthResponseDTO(String accesToken) {
		this.accesToken = accesToken;
	}
	
	
}
