package com.example.Centaure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CadastroController {
    @GetMapping("/cadastro")
    public String cadastro(){
        return "cadastro_usuario";
    }
}
