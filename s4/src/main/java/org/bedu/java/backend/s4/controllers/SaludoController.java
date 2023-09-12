package org.bedu.java.backend.s4.controllers;

import org.bedu.java.backend.s4.models.Saludo;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saludo")
    public Saludo saludo(@RequestBody Saludo saludo){
        return saludo;
    }

    @PutMapping("/saludo")
    public Saludo saluda(@RequestBody Saludo saludo){
        saludo.setFechaNacimiento(saludo.getFechaNacimiento().plusDays(1));
        return saludo;
    }

}
