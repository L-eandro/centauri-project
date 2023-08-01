package com.example.centaure.Centaure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.centaure.Centaure.models.Veiculo;

@Controller
public class VeiculoController {

    // Página de cadastro de veículo
    @GetMapping("/cadastro/veiculo")
    public String cadastroVeiculo(){
        return "/veiculo_html/cadastro_veiculo";
    }

    // Página de edição de veículo
    @GetMapping("/editar/veiculo")
    public String editarVeiculo(){
        return "/veiculo_html/editar_veiculo";
    }

    // Página de listagem de veículos
    @GetMapping("/listar/veiculo")
    public String listarVeiculo(){
        return "/veiculo_html/listar_veiculo";
    }

    // Página de formulário de solicitação de serviço
    @GetMapping("/FormSolicitacao/usuario")
    public String formSolicitacao(){
        return "servico_html/form_solicitacao_servico";
    }

    // Página de listagem de serviços de frete
    @GetMapping("/listarFrete/servico")
    public String listarFrete(){
        return "servico_html/listando_servico_frete";
    }

    // Página de listagem de serviços de mudança
    @GetMapping("/listarMudanca/servico")
    public String listarMudanca(){
        return "servico_html/listando_servico_mudanca";
    }

    // Página de listagem de serviços de viagem
    @GetMapping("/listarViagem/servico")
    public String listarViagem(){
        return "servico_html/listando_servico_viagem";
    }

}
