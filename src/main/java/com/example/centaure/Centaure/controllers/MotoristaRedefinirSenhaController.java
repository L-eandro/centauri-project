package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.service.MotoristaService;
import extencao.MotoristaInvalid;
import extencao.MotoristaNonexistentExcepition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MotoristaRedefinirSenhaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping("/esqueci/senha")
    public String esqueciSenha(){
        return "/motorista_html/esqueceu_senha_motorista";
    }

    @PostMapping("/esqueci/senha")
    public  String esqueciSenha2(String email, RedirectAttributes ra){

        try {
            motoristaService.pedidoAlterarSenha(email);
            return "/motorista_html/redefinindo_senha_motorista";

        } catch (MotoristaNonexistentExcepition me){
            ra.addFlashAttribute("msgErroAdd", me.getMessage());
            ra.addFlashAttribute("style","margin-left: 140px; color: red;");
        }
        return "redirect:/esqueci/senha";

    }

    @GetMapping("/redefinir/senha")
    public String redefinirSenha(){
        return "/motorista_html/redefinindo_senha_motorista";
    }

    @PostMapping("/redefinir/senha")
    public String redefinirSenha2(Motorista motorista, String passwordValid, Model model, RedirectAttributes ra){

        try {

            motoristaService.validPassword(motorista, passwordValid);

            Motorista u = motoristaService.searchByCod(motorista.getCodVerificar());

            motoristaService.validCod(u, motorista);

            motoristaService.alterPassword(u, motorista.getSenha());

            ra.addFlashAttribute("msgSenhaAlterada","Senha alterada com sucesso");
            ra.addFlashAttribute("style","margin-left: 50px; color: green;");

            return "redirect:/redefinir/senha";

        } catch (MotoristaInvalid e) {
            ra.addFlashAttribute("msgErro2");
            ra.addFlashAttribute("style","margin-left: 140px; color: red;");
        }
        return "redirect:/redefinir/senha";
    }


}
