package com.argprogr.portfolioweb.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argprogr.portfolioweb.dto.JwtDTO;
import com.argprogr.portfolioweb.dto.Mensaje;
import com.argprogr.portfolioweb.dto.UserDTO;
import com.argprogr.portfolioweb.repository.UsuarioRepository;
import com.argprogr.portfolioweb.security.JWTTokenProvider;
import com.argprogr.portfolioweb.service.RolService;
import com.argprogr.portfolioweb.service.UsuarioService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {
	
    @Autowired
    PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsuarioRepository usuarioRepo;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	RolService rolService;
	@Autowired
	JWTTokenProvider tokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<JwtDTO> login(@RequestBody UserDTO dto, BindingResult bindingResult){
		
        if(bindingResult.hasErrors()) {
        	return new ResponseEntity(new Mensaje("Campos mal puestos."), HttpStatus.BAD_REQUEST);
        }
            
		Authentication authentication = 
				authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//Obtener token del Provider
		String token = tokenProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		JwtDTO jwtDto = new JwtDTO(token, userDetails.getUsername(), userDetails.getAuthorities()); 
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
	
	/* Sin uso hasta que se puedan armar perfiles de usuario.
    @PostMapping("/registro")
    public ResponseEntity<?> registro(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

	//TODO Arreglar. Siempre elimina aunque no encuentre usuario.
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		Optional<Usuario> opt = usuarioRepo.findById(id);
		
			if (opt.isEmpty()){
				return new ResponseEntity<String>("Usuario no encontrado.", HttpStatus.BAD_REQUEST);

			} else {
				usuarioService.deleteUsuarioById(id);
				return new ResponseEntity<String>("Usuario eliminado.", HttpStatus.OK);
			}
	}
	*/
	
	}