package com.example.Centaure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RedefinirSenhaController {
    @GetMapping("/redefinir/senha")
    public String redefinirsenha() {return "redefinindo_senha";}
}
