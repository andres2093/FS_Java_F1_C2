package org.bedu.java.backend.s8.runners;

import org.bedu.java.backend.s8.models.Etapa;
import org.bedu.java.backend.s8.persistence.EtapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EtapasVentaRunner implements CommandLineRunner {

    private final EtapaRepository etapaRepository;

    @Autowired
    public EtapasVentaRunner(EtapaRepository etapaRepository) {
        this.etapaRepository = etapaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Etapa> etapas =  new ArrayList<>();
        etapas.add(creaEtapa("En espera", 1));
        etapas.add(creaEtapa("Etapa 2", 2));
        etapas.add(creaEtapa("Etapa 3", 3));
        etapas.add(creaEtapa("Etapa 4", 4));
        etapas.add(creaEtapa("Etapa 5", 5));
        etapas.add(creaEtapa("Etapa 6", 6));

//        etapaRepository.saveAll(etapas);
    }

    private Etapa creaEtapa(String nombre, Integer orden){
        Etapa etapa = new Etapa();
        etapa.setNombre(nombre);
        etapa.setOrden(orden);
        return etapa;
    }
}
