package com.example.Centaure.Controller;
import com.example.Centaure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Centaure.models.Usuario;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @GetMapping("/cadastro")
    public String cadastro(){ return "cadastro_usuario"; }

    @PostMapping("/cadastro")
    public String criar(Usuario usuario){
        this.usuarioService.criar(usuario);
        return "redirect:/cadastro";
    }
}
