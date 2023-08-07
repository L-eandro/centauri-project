package com.example.centaure.Centaure.controllers;


import com.example.centaure.Centaure.service.VeiculoService;


import extencao.VeiculoInvalid;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.centaure.Centaure.models.Veiculo;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;


    // Página de cadastro de veículo
    @GetMapping("/veiculo/cadastrar")
    public String cadastrarVeiculo(){
        return "/veiculo_html/cadastro_veiculo";
    }


    @PostMapping("/veiculo/cadastrar")
    public String criar(Veiculo veiculo, RedirectAttributes ra ,  Model model){

        try {
            this.veiculoService.salvar(veiculo);
            this.veiculoService.criar(veiculo);
            return "redirect:/veiculo/listar";

        } catch (VeiculoInvalid e ){
            ra.addFlashAttribute("msgError", e.getMessage() );
            ra.addFlashAttribute("style","margin-left: 150px; color: red;");
            return "redirect:/veiculo/cadastrar";
        }
        
    }

     @GetMapping("/veiculo/listar")
     public String listar(Model model, Veiculo veiculo ){
        model.addAttribute("veiculo", this.veiculoService.listar(veiculo));
        return "veiculo_html/listar_veiculo";
    }

     @GetMapping("/veiculo/deletar/{id}")
     public String deletar(@PathVariable Integer id){
        veiculoService.deletar(id);
        return "redirect:/veiculo/listar";
    }

    @GetMapping("/veiculo/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Optional<Veiculo> veiculo = this.veiculoService.editar(id);
        model.addAttribute("veiculo", veiculo);
        return "veiculo_html/editar_veiculo";
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
