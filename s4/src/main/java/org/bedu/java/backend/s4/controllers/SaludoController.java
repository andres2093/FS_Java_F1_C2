package org.bedu.java.backend.s4.controllers;

import org.bedu.java.backend.s4.models.Saludo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/saludo")
    public Saludo saluda(){
        Saludo saludo = new Saludo();
        saludo.setMensaje("Hola Bedu!!!");
        return saludo;
    }

    @GetMapping("/saludo/{nombre}")
    public Saludo saluda(@PathVariable String nombre){

        Saludo saludo = new Saludo();
        saludo.setMensaje("Hola Bedu!!!");
        saludo.setNombre(nombre);

        return saludo;
    }
}