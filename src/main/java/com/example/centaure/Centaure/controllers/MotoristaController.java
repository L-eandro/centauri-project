package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.service.MotoristaService;
import extencao.MotoristaInvalid;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MotoristaController {
    @Autowired
    private MotoristaService motoristaService;

    // Referente ao login
    @GetMapping("/login/motorista")
    public String Login(){
        return "motorista_html/login_motorista";
    }

    @PostMapping("/login/motorista")
    public String login( Motorista motorista,HttpSession session, Model model, String email, String senha){
         motorista = motoristaService.findByEmailAndPassword(email,senha);

        if (motorista != null) {
            session.setAttribute("logged", motorista);
            return "redirect:/listar/veiculo";
        } else {
            model.addAttribute("message", "E-mail ou senha incorretos");
            model.addAttribute("style", "margin-left: 120px; color: red;");
            return "/motorista_html/login_motorista";
        }
    }
    //--------------

    // Referente ao cadastro

    @GetMapping("/cadastro/motorista")
    public String cadastroMotorista() {
        return "motorista_html/cadastro_motorista";
    }

    @PostMapping("/cadastro/motorista")
    public String criar(Motorista motorista, RedirectAttributes ra){
        try {
            motoristaService.salvar(motorista);
            motorista.setSenha(motoristaService.criptografarSenha(motorista));
            motoristaService.criar(motorista);
            ra.addFlashAttribute("msgSucess", "Conta criada com sucesso!");
            ra.addFlashAttribute("style","margin-left: 120px; color: green;");
            return "redirect:/cadastro/motorista";

        } catch (MotoristaInvalid e ){
            ra.addFlashAttribute("msgError", e.getMessage() );
            ra.addFlashAttribute("style","margin-left: 150px; color: red;");
        }
        return "redirect:/cadastro/motorista";
    }

    //--------------

    @GetMapping("/motorista/sair")
    public String sair(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/esqueci/senha")
    public String esqueciSenha(){
        return "/motorista_html/esqueceu_senha_motorista";
    }

    @GetMapping("/acesso-negado")
    public String acessoNegado(){
        return "acesso_negado";
    }



    @GetMapping("/motorista/listar")
    public String listar(Model model, Motorista motorista ){
        model.addAttribute("motorista", this.motoristaService.listar(motorista));
        return "listar_motorista";
    }

    @GetMapping("/motorista/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Optional<Motorista> motorista = this.motoristaService.editar(id);
        model.addAttribute("motorista", motorista);
        return "motorista_html/editar_motorista";
    }

    @GetMapping("/motorista/deletar/{id}")
    public String deletar(@PathVariable Integer id){
        motoristaService.deletar(id);
        return "redirect:/motorista/listar";
    }

}
