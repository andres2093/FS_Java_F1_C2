package org.bedu.java.backend.s5.e1.config;

import org.bedu.java.backend.s5.e1.models.Saludo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaludoConfig {

    @Bean
    public Saludo saludo(){
        return new Saludo("Beto");
    }
}
