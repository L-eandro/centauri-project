package com.example.Centaure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class VeiculoController {
    @GetMapping("/veiculo")
    public String veiculo(){return "cadastro_veiculo";}
}