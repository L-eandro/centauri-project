package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Usuario;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ServicoViagemController {

    @GetMapping("/usuario/escolher/viagem")
    public String ServicoViagem(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "servico_html/listando_servico_viagem";
    }
}
