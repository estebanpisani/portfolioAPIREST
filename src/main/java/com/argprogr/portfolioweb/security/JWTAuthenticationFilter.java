package com.argprogr.portfolioweb.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JWTTokenProvider jwtTokenProvider;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			// Obtener el token de la solicitud HTTP
			String token = getJWTFromRequest(request);
			// Validar Token
			try {
				if(StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
					// Obtener el username del token
					String username = jwtTokenProvider.getUsernameFromToken(token);
					// Cargar usuario asociado al Token
					UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
					UsernamePasswordAuthenticationToken authenticationToken = 
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					//Establecer seguridad
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);	
				}
				filterChain.doFilter(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Fail en método doFilterInternal");
			}
	}
	
	//Bearer token de acceso
	private String getJWTFromRequest(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if(StringUtils.hasText(header)&& header.startsWith("Bearer ")) {
			return header.substring(7, header.length());
		}
		return null;
	}

	
}
