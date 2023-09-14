package org.bedu.java.backend.s5.e2.models;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// Con component le indicamos a Spring que gestiene
// las instancias del modelo y las inyecte donde las necesitemos
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// El valor de arriba es para cancelar el singleton al momento de
// obtener instancias
public class SaludoComponent {
    private final String nombre;

    public SaludoComponent() {
        this.nombre = "Beto";

        System.out.println("Creando una instancia de Saludo");
    }

    public String getNombre() {
        return nombre;
    }
}
