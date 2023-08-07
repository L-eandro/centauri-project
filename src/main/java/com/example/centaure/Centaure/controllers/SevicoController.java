package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SevicoController {


    // Página para escolher o tipo de serviço
    @GetMapping("/usuario/escolher/servico")
    public String escolherServico(Model model, Usuario usuario){
        // Adiciona o objeto "usuario" ao modelo para ser utilizado na página
        model.addAttribute("usuario", usuario);
        return "servico_html/escolher_servico";
    }


     // Página de listagem de veículos
    @GetMapping("/motorista/inicio")
    public String principal(Model model,Motorista motorista){
        model.addAttribute("motorista", motorista);
        return "/motorista_html/inicio_motorista";
    }

    //metodo para mostrar os motorista disponieis no site de acordo com oque o usuairo escolher na escolher_servico.


}
