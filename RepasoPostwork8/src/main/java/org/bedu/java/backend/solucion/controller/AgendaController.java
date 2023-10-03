package org.bedu.java.backend.solucion.controller;

import jakarta.validation.Valid;
import org.bedu.java.backend.solucion.model.Persona;
import org.bedu.java.backend.solucion.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgendaController {

    private final AgendaService agendaService;


    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaService.getPersonas());

        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona, Errors errors) {
        ModelAndView mav = new ModelAndView("index");

        if (!errors.hasErrors()) {
            if (agendaService.getPersonas().stream().filter(
                    item -> persona.getTelefono().equals(item.getTelefono())).findFirst().orElse(null) != null){

                mav.addObject("value", true);
            } else {
                agendaService.guardaPersona(persona);
            }
        }

        mav.addObject("listaPersonas", agendaService.getPersonas());
        return mav;
    }

}
