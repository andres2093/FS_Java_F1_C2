package org.bedu.java.backend.s5.e2.services;

import org.bedu.java.backend.s5.e2.models.SaludoComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaludoService {

    private final SaludoComponent saludoComponent;

    @Autowired
    public SaludoService(SaludoComponent saludoComponent) {
        this.saludoComponent = saludoComponent;
    }

    public String saluda(){
        return "Hola " + saludoComponent.getNombre();
    }
}
