package com.example.Centaure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class EnderecoController {
    @GetMapping("/endereco")
    public String endereco() { return "cadastro_endereco"; }
}