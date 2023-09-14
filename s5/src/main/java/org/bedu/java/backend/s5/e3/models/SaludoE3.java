package org.bedu.java.backend.s5.e3.models;

import org.springframework.stereotype.Component;

@Component
public class SaludoE3 {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
