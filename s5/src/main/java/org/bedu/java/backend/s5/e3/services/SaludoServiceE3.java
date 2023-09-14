package org.bedu.java.backend.s5.e3.services;

import jakarta.annotation.PostConstruct;
import org.bedu.java.backend.s5.e3.models.SaludoE3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaludoServiceE3 {

    private final SaludoE3 saludoE3;

    @Autowired
    public SaludoServiceE3(SaludoE3 saludoE3) {
        this.saludoE3 = saludoE3;
    }

    @PostConstruct
    public void init(){
        saludoE3.setNombre("Beto");
    }

    public String saluda(){
        return "Hola " + saludoE3.getNombre();
    }
}
