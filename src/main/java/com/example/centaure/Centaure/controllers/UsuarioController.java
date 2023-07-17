package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.service.UsuarioServive;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioServive usuarioServive;

    @GetMapping("/cadastro/usuario")
    public String cadastro(){
        return "cadastro_usuario";
    }

    @PostMapping("/cadastro/usuario")
    public String criar(Usuario usuario){
        this.usuarioServive.criar(usuario);
        return "redirect:/cadastro/usuario";
    }

    @GetMapping("/usuario/listar")
    public String listar(Model model, Usuario usuario ){
        model.addAttribute("usuario", this.usuarioServive.listar(usuario));
        return "listar_usuario";
    }


}
