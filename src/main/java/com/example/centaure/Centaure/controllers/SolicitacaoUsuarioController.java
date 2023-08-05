package com.example.centaure.Centaure.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.centaure.Centaure.models.SolicitacaoUsuario;
import com.example.centaure.Centaure.service.SolicitacaoUsuarioService;
import extencao.SolicitacaoUsuarioInvalid;

@Controller
public class SolicitacaoUsuarioController {
    

    @Autowired
    private SolicitacaoUsuarioService solicitacaoUsuarioService;



     @GetMapping("/usuario/solicitacao")
    public String solicitaca() {
        return "servico_html/form_solicitacao_servico";
    }

    @PostMapping("/usuario/solicitacao")
    public String criar(SolicitacaoUsuario solicitacaoUsuario, RedirectAttributes ra ,  Model model){
        try {
            this.solicitacaoUsuarioService.salvar(solicitacaoUsuario);
            this.solicitacaoUsuarioService.criar(solicitacaoUsuario);
            return "redirect:/usuario/solicitacao/listar";

        } catch (SolicitacaoUsuarioInvalid e ){
            ra.addFlashAttribute("msgError", e.getMessage() );
            ra.addFlashAttribute("style","margin-left: 150px; color: red;");
            return "redirect:/usuario/solicitacao";
        }
        
    }


     @GetMapping("/usuario/solicitacao/listar")
    public String listar(Model model, SolicitacaoUsuario solicitacaoUsuario ){
        model.addAttribute("solicitacaoUsuario", this.solicitacaoUsuarioService.listar(solicitacaoUsuario));
        return "usuario_html/listar_solicitacoes_usuario";
    }

    @GetMapping("/usuario/solicitacao/deletar/{id}")
    public String deletar(@PathVariable Integer id){
        solicitacaoUsuarioService.deletar(id);
        return "redirect:/usuario/solicitacao/listar";
    }


}
