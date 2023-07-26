package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.service.UsuarioServive;
import extencao.UserInvalid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioServive usuarioServive;

    @GetMapping("/cadastro/usuario")
    public String cadastro(){
        return "usuario_html/cadastro_usuario";
    }

    @PostMapping("/cadastro/usuario")
    public String criar( Usuario usuario,RedirectAttributes ra  )  {
        try {
            usuarioServive.salvando(usuario);
            usuarioServive.criar(usuario);
            return "redirect:/cadastro/usuario";
        }
        catch (UserInvalid e) {
            ra.addFlashAttribute("msgError", e.getMessage());
        }
        return "redirect:/cadastro/usuario";
    }
    @GetMapping("/usuario/listar")
    public String listar(Model model, Usuario usuario ){
        model.addAttribute("usuario", this.usuarioServive.listar(usuario));
        return "listar_usuario";
    }
    @GetMapping("/usuario/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Optional<Usuario> usuario = this.usuarioServive.editar(id);
        model.addAttribute("usuario", usuario);
        return "usuario_html/editar_usuario";
    }
    @GetMapping("/usuario/deletar/{id}")
    public String deletar(@PathVariable Integer id){
        usuarioServive.deletar(id);
        return "redirect:/usuario/listar";
    }
}
