package com.example.centaure.Centaure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.centaure.Centaure.models.Veiculo;

@Controller
public class VeiculoController {


    @GetMapping("/cadastro/veiculo")
    public String cadastroVeiculo(){
        return "/veiculo_html/cadastro_veiculo";
    }

    @GetMapping("/editar/veiculo")
    public String editVeiculo(){
        return "/veiculo_html/editar_veiculo";
    }


    @GetMapping("/listar/veiculo")
    public String listarVeiculo(){
        return "/veiculo_html/listar_veiculo";
    }
}
