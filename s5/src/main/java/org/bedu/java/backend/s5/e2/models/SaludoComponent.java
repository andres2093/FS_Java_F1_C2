package org.bedu.java.backend.s5.e2.models;

import org.springframework.stereotype.Component;

@Component
// Con component le indicamos a Spring que gestiene
// las instancias del modelo y las inyecte donde las necesitemos
public class SaludoComponent {
    private final String nombre;

    public SaludoComponent() {
        this.nombre = "Beto";
    }

    public String getNombre() {
        return nombre;
    }
}
