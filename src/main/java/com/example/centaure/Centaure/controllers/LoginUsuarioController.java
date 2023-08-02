package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.service.UsuarioServive;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginUsuarioController {
    @Autowired
    private UsuarioServive usuarioServive;

    @GetMapping("/acessonegado")
    public String acessoNegado(){
        return "acesso_negado";
    }

    @GetMapping("/login/usuario")
    public String login(){
        return "usuario_html/login_usuario";
    }

    // Processa o login do usuário
    @PostMapping("/login/usuario")
    public String login(Usuario usuario, HttpSession session, Model model){
        // Verifica se o usuário existe no banco de dados com o email e senha fornecidos
        usuario = this.usuarioServive.findByEmailAndSenha(usuario.getEmail(),usuario.getSenha());
        if (usuario !=null){
            session.setAttribute("logado", usuario);
            session.setAttribute("usuario", 1);
            // Se o usuário existe, armazena-o na sessão e redireciona para a página de escolha de serviço
            return "redirect:/usuario/escolher/servico";
        } else {
            // Se o usuário não existe, exibe uma mensagem de erro e redireciona de volta para a página de login
            model.addAttribute("message", "E-mail ou senha incorretos");
            model.addAttribute("style", "margin-left: 120px; color: red;");
            return "/usuario_html/login_usuario";
        }
        // Página de sair (logout) do usuário
    }
    @GetMapping("usuario/sair")
    public String sair(HttpSession session){
        // Invalida a sessão do usuário e redireciona para a página inicial
        session.invalidate();
        return "redirect:/";
    }
}
