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

    @GetMapping("/login/motorista")
    public String Login(){
        return "motorista_html/login_motorista";
    }

    @PostMapping("/login/motorista")
    public String login(@RequestParam String email, @RequestParam String senha, HttpSession session, RedirectAttributes re){
        Motorista motorista = motoristaService.login(email,senha);
        if(motorista != null){
            session.setAttribute("logado", motorista);
            return "redirect:/listar/veiculo";
        } else {
            re.addFlashAttribute("msg", "login ou senha incorretas!");
            return "redirect:/login/motorista";
        }
    }

    @GetMapping("/cadastro/veiculo")
    public String cadastroVeiculo(){
        return "/veiculo_html/cadastro_veiculo";
    }

    @GetMapping("/editar/veiculo")
    public String editVeiculo(){
        return "/veiculo_html/editar_veiculo";
    }


    @GetMapping("/listar/veiculo")
    public String listarVeiculo(){
        return "/veiculo_html/listar_veiculo";
    }



    @GetMapping("/esqueci/senha")
    public String esqueciSenha(){
        return "/motorista_html/esqueceu_senha_motorista";
    }

    @GetMapping("/escolher/servico")
    public String escolherServico(){
        return "/servico_html/escolher_servico";
    }




    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/cadastro/motorista")
    public String cadastroMotorista() {
        return "motorista_html/cadastro_motorista";
    }

    @PostMapping("/cadastro/motorista")
    public String criar(Motorista motorista, RedirectAttributes ra){
        try {
            motoristaService.salvar(motorista);
            motoristaService.criar(motorista);
            ra.addFlashAttribute("msgSucess", "Conta criada com sucesso!");
            return "redirect:/cadastro/motorista";

        } catch (MotoristaInvalid e ){
            ra.addFlashAttribute("msgError", e.getMessage() );}
            return "redirect:/cadastro/motorista";
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
