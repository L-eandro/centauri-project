package com.example.centaure.Centaure.controllers;


import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MotoristaOutrosController {
    @Autowired
    private MotoristaService motoristaService;


    @GetMapping("/motorista/listar")
    public String listar(Model model, Motorista motorista ){
        model.addAttribute("motorista", this.motoristaService.listar(motorista));
        return "listar_motorista";
    }

    @GetMapping("/motorista/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Optional<Motorista> motorista = this.motoristaService.editar(id);
        model.addAttribute("motorista", motorista);
        return "motorista_html/editar_motorista";
    }

    @GetMapping("/motorista/deletar/{id}")
    public String deletar(@PathVariable Integer id){
        motoristaService.deletar(id);
        return "redirect:/motorista/listar/veiculo";
    }

}
