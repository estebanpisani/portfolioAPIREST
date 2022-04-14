package com.argprogr.portfolioweb.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;




public class JwtDTO {
    private String token;
    private String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
	public JwtDTO(String token, String username, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.token = token;
		this.username = username;
		this.authorities = authorities;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
    
    
}
