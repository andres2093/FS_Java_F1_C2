package org.bedu.java.backend.s7.controllers;

import org.bedu.java.backend.s7.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registro(Usuario usuario){
        ModelAndView modelAndView = new ModelAndView("registroExitoso");
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }
}
