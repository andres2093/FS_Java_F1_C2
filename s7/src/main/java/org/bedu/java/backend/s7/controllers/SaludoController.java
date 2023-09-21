package org.bedu.java.backend.s7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaludoController {

    @GetMapping("/hola")
    public ModelAndView hola(){
        ModelAndView modelAndView = new ModelAndView("hola");
        modelAndView.addObject("mensaje", "Hola desde thymeleaf");
        return modelAndView;
    }
}
