package com.argprogr.portfolioweb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.argprogr.portfolioweb.security.CustomUserDetailsService;
import com.argprogr.portfolioweb.security.JWTAuthenticationEntryPoint;
import com.argprogr.portfolioweb.security.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	@Autowired
	JWTAuthenticationEntryPoint authenticationEntryPoint;
	
	@Bean
	public JWTAuthenticationFilter filter() {
		return new JWTAuthenticationFilter();
	}
	
	
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		// Deshabilitar CSRF
		.csrf().disable()
		//
		.exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()		
		// Configurar autorización
		.authorizeRequests()
		//Autoriza recursos a cualquiera
		.antMatchers(HttpMethod.GET, "/api/**").permitAll()
		.antMatchers("/api/auth/**").permitAll()
		//	Cualquier otro tiene que ser autenticado.
		.anyRequest()
		.authenticated();
		// Agregar filtro
		http.addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class);
		
		/*Tipo de Autenticación Básica.
		.httpBasic();
		*/
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Asignamos el userDetailsService y el Password Encoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}



	
	
	
	
	
	

}
