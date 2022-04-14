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
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Asignamos el userDetailsService y el Password Encoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors()
		.and()
		.csrf().disable() // Deshabilitar CSRF
		.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint) // Dispara excepción de "No autorizado."
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()		
		.authorizeRequests() // Configurar autorización
		.antMatchers(HttpMethod.GET, "/api/**").permitAll() //	Autoriza recursos a cualquiera
		.antMatchers("/api/auth/**").permitAll()
		.anyRequest().authenticated(); //Cualquier otro tiene que ser autenticado.
		
		// Agregar filtro
		http.addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	




	
	
	
	
	
	

}
