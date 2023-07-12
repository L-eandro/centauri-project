package com.example.Centaure.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mvh =new ModelAndView("index");
        return mvh;
    }
    @GetMapping("/home/cadastro_usuario")
    public ModelAndView cadastro() {
        ModelAndView mvcd = new ModelAndView("cadastro_usuario");
        return mvcd;
    }
    @GetMapping("/home/login")
    public ModelAndView login_usuario(){
        ModelAndView mvll = new ModelAndView("login");
        return mvll;
    }
}