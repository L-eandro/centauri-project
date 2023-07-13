package com.example.Centaure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginUsuarioController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
