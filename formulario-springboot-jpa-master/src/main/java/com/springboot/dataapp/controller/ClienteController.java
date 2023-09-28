package com.springboot.dataapp.controller;

import com.springboot.dataapp.models.entity.Cliente;
import com.springboot.dataapp.models.service.IclienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    private IclienteService clienteService;

    @GetMapping({"", "/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.listar());
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Model model) {
        model.addAttribute("titulo", "Formulario de cliente");
        model.addAttribute("cliente", new Cliente());

        return "form";
    }

    @GetMapping("/form/{id}")
    public String actualizar(@PathVariable Long id, Model model) {
        Cliente cliente = null;
        if (id > 0) {
            cliente = clienteService.porId(id);
        } else {
            return "redirect:listar";
        }
        model.addAttribute("titulo", "Editar cliente");
        model.addAttribute("cliente", cliente);
        return "form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("titulo", "Formulario de cliente");
            return "form";
        }//redirige a la pagina /listar guardando los cambios con 'redirect:'
        clienteService.guardar(cliente);
        return "redirect:listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model) {

        if (id > 0) {
            clienteService.eliminar(id);
        } //redirige a la pagina /listar guardando los cambios con 'redirect:'
        return "redirect:/listar";
    }
}
