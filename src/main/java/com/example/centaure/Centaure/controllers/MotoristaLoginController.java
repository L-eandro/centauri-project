package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.service.MotoristaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotoristaLoginController {


    @Autowired
    private MotoristaService motoristaService;

    @GetMapping("/acesso-negado")
    public String acessoNegado(){
        return "acesso_negado";
    }

    @GetMapping("/login/motorista")
    public String Login(){
        return "motorista_html/login_motorista";
    }

    @PostMapping("/login/motorista")
    public String login(Motorista motorista, HttpSession session, Model model, String email, String senha){
        motorista = motoristaService.findByEmailAndPassword(email,senha);

        if (motorista != null) {
            session.setAttribute("logged", motorista);
            session.setAttribute("motorista", 1);
            return "redirect:/motorista/inicio";
        } else {
            model.addAttribute("message", "E-mail ou senha incorretos");
            model.addAttribute("style", "margin-left: 120px; color: red;");
            return "/motorista_html/login_motorista";
        }
    }

    @GetMapping("motorista/sair")
    public String sair(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
