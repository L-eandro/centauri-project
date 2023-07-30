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
    public String editarVeiculo(){
        return "/veiculo_html/editar_veiculo";
    }


    @GetMapping("/listar/veiculo")
    public String listarVeiculo(){
        return "/veiculo_html/listar_veiculo";
    }


    @GetMapping("/FormSolicitacao/usuario")
    public String formSolicitacao(){
        return "servico_html/form_solicitacao_servico";
    }


       @GetMapping("/listarFrete/servico")
    public String listarFrete(){
        return "servico_html/listando_servico_frete";
    }


       @GetMapping("/listarMudanca/servico")
    public String listarMudanca(){
        return "servico_html/listando_servico_mudanca";
    }

       @GetMapping("/listarViagem/servico")
    public String listarViagem(){
        return "servico_html/listando_servico_viagem";
    }





}
