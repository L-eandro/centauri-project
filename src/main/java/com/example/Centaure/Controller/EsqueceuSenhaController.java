package com.example.Centaure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EsqueceuSenhaController {
    @GetMapping("/esqueceu/senha")
    public String esqueceusenha() {return "esqueceu_senha";}



}
