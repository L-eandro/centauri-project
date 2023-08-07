package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.service.MotoristaService;
import extencao.MotoristaInvalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MotoristaCadastroController {


    @Autowired
    private MotoristaService motoristaService;

    // Referente ao cadastro
    @GetMapping("/cadastro/motorista")
    public String cadastroMotorista() {
        return "motorista_html/cadastro_motorista";
    }

    @PostMapping("/cadastro/motorista")
    public String criar(Motorista motorista, RedirectAttributes ra){

        try {
            motoristaService.salvar(motorista);
            motorista.setSenha(motoristaService.criptografarSenha(motorista));
            motoristaService.criar(motorista);
            motoristaService.emailSender(motorista);
            ra.addFlashAttribute("msgSucess", "Conta criada com sucesso!");
            ra.addFlashAttribute("style","margin-left: 120px; color: green;");
            return "redirect:/cadastro/motorista";

        } catch (MotoristaInvalid e ){
            ra.addFlashAttribute("msgError", e.getMessage() );
            ra.addFlashAttribute("style","margin-left: 150px; color: red;");
        }
        return "redirect:/cadastro/motorista";
    }
    //--------------
}
