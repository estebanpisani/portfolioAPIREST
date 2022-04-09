package com.argprogr.portfolioweb.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.argprogr.portfolioweb.model.UsuarioPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTTokenProvider {
	
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	@Value("${app.jwt-expiration-milliseconds}")
	private Long jwtExpirationInMs;
	
	public String generateToken(Authentication authentication) {
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();

        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationInMs * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

	}
	
	public String getUsernameFromToken(String token) {
		
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) throws Exception {
		
		try {
			
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;			
		}
		catch (SignatureException ex) {
			throw new Exception("Firma JWT no válida");
		}
		catch (MalformedJwtException ex) {
			throw new Exception("JWT no válido");
		}
		catch (ExpiredJwtException ex) {
			throw new Exception("JWT caducado.");
		}
		catch (UnsupportedJwtException ex) {
			throw new Exception("JWT no compatible.");
		}
		catch (IllegalArgumentException ex) {
			throw new Exception("La cadena Claims del JWT está vacía.");
		}
	}

}
