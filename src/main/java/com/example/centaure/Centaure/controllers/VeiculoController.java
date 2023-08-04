package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.centaure.Centaure.models.Veiculo;

@Controller
public class VeiculoController {

    @Autowired
    private MotoristaService motoristaService;

    // Página de cadastro de veículo
    @GetMapping("/motorista/cadastro/veiculo")
    public String cadastroVeiculo(){
        return "/veiculo_html/cadastro_veiculo";
    }

    // Página de edição de veículo
    @GetMapping("/motorista/editar/veiculo")
    public String editarVeiculo(Motorista motorista, Model model) {
        return "/veiculo_html/editar_veiculo";
    }

    // Página de listagem de veículos
    @GetMapping("/motorista/listar/veiculo")
    public String listarVeiculo(Motorista motorista, Model model){
        model.addAttribute("motorista", this.motoristaService.listar(motorista));
        return "/veiculo_html/listar_veiculo";
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
