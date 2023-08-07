package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ServicoMudancaController {
    @GetMapping("/usuario/escolher/servico/mudanca")
    public String ServicoMudanca(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "servico_html/listando_servico_mudanca";
    }
}
