package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SevicoController {

    @GetMapping("/escolher/servico")

    public String escolherServico(Model model, Usuario usuario){
        model.addAttribute("usuario", usuario);
        return "servico_html/escolher_servico";
    }

}
