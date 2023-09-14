package org.bedu.java.backend.s5.e2.services;

import org.bedu.java.backend.s5.e2.models.SaludoComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaludoService {

    private final SaludoComponent saludoComponent;
    private final SaludoComponent otroSaludoComponent;

    @Autowired
    public SaludoService(SaludoComponent saludoComponent, SaludoComponent otroSaludoComponent) {
        this.saludoComponent = saludoComponent;
        this.otroSaludoComponent = otroSaludoComponent;

        System.out.println(saludoComponent == otroSaludoComponent);
    }

    public String saluda(){
        return "Hola " + saludoComponent.getNombre();
    }
}
