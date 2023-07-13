package com.example.Centaure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ServicoController {
    @GetMapping("/servico")
    public String servico() {return "escolher_servico";}
}
