package com.example.Centaure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MotoristaController {
    @GetMapping("/motorista")
    public String motorista() {return "cadastro_motorista";}
}
