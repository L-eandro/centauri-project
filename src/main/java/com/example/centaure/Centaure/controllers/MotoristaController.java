package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MotoristaController {
    @Autowired
    private MotoristaService motoristaService;

    @GetMapping("/cadastro/motorista")
    public String cadastroMotorista() {
        return "cadastro_motorista";
    }

    @PostMapping("/cadastro/motorista")
    public String criar(Motorista motorista){
        this.motoristaService.criar(motorista);
        return "redirect:/cadastro/motorista";
    }

    @GetMapping("/motorista/listar")
    public String listar(Model model, Motorista motorista ){
        model.addAttribute("motorista", this.motoristaService.listar(motorista));
        return "listar_motorista";
    }

    @GetMapping("/motorista/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Optional<Motorista> motorista = this.motoristaService.editar(id);
        model.addAttribute("motorista", motorista);
        return "motorista_editar";
    }

    @GetMapping("/motorista/deletar/{id}")
    public String deletar(@PathVariable Integer id){
        motoristaService.deletar(id);
        return "redirect:/motorista/listar";
    }

}
