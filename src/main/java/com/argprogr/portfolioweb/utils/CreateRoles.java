package com.argprogr.portfolioweb.utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.argprogr.portfolioweb.enums.RolNombre;
import com.argprogr.portfolioweb.model.Rol;
import com.argprogr.portfolioweb.model.Usuario;
import com.argprogr.portfolioweb.service.RolService;
import com.argprogr.portfolioweb.service.UsuarioService;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UsuarioService usuarioService;

    @Override
    public void run(String... args) throws Exception {
    	
//    	Scanner scan = new Scanner(System.in);
//
//        System.out.println("Creando roles...");    	
//        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
//        Rol rolUser = new Rol(RolNombre.ROLE_USER);
//        rolService.save(rolAdmin);
//        rolService.save(rolUser);
//        System.out.println("Roles creados..."); 
//
//        System.out.println("Creando usuario..."); 
//        System.out.println("Ingrese el username");
//        String username = scan.next();
//        System.out.println("Ingrese el password");        
//        String password = scan.next();    
//        
//        Usuario usuario = new Usuario(username, encoder.encode(password));
//        System.out.println("Asignando roles...");
//        Set<Rol> roles = new HashSet<>();
//        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
//        roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
//        usuario.setRoles(roles);
//        System.out.println("Guardando usuario...");
//        usuarioService.saveUsuario(usuario);
        
    }
}
