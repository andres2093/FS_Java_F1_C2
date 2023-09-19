package org.bedu.java.backend.s6.e1.controllers;

import org.bedu.java.backend.s6.e1.models.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @PostMapping
    public String creaUsuario(@RequestBody Usuario usuario){
        System.out.println("Creando usuario");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Usuario: " + usuario.getUsuario());
        System.out.println("Correo: " + usuario.getCorreoElectronico());
        System.out.println("Contraseña: " + usuario.getContrasenia());

        return "Usuario creado!!!";
    }

    @PostMapping("/{id}")
    public String creaUsuario(@RequestBody Usuario usuario, @PathVariable("id") long id){
        System.out.println("Creando usuario");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Usuario: " + usuario.getUsuario());
        System.out.println("Correo: " + usuario.getCorreoElectronico());
        System.out.println("Contraseña: " + usuario.getContrasenia());

        return "Usuario " + id + " creado!!!";
    }

    @GetMapping
    public String creaUsuarioR1(@RequestBody Usuario usuario, @RequestParam("id") long id, @RequestParam("rol") String rol){
        System.out.println("Creando usuario");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Usuario: " + usuario.getUsuario());
        System.out.println("Correo: " + usuario.getCorreoElectronico());
        System.out.println("Contraseña: " + usuario.getContrasenia());
        System.out.println("Rol: " + rol);

        return "Usuario " + id + " creado!!!";
    }
}
