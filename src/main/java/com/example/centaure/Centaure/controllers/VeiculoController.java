package com.example.centaure.Centaure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.centaure.Centaure.models.Veiculo;

@Controller
public class VeiculoController {


    @ModelAttribute("veiculoo")
    public Veiculo[] getEnumVeiculo(){
        return Veiculo.values();
    }
    
}
