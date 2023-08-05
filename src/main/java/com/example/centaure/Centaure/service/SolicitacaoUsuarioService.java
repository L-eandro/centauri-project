package com.example.centaure.Centaure.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.centaure.Centaure.models.EnderecoChegada;
import com.example.centaure.Centaure.models.EnderecoPartida;
import com.example.centaure.Centaure.models.SolicitacaoUsuario;
import com.example.centaure.Centaure.repositores.SolicitacaoUsuarioRepositores;


import extencao.SolicitacaoUsuarioInvalid;

@Service
public class SolicitacaoUsuarioService {

    @Autowired
    private SolicitacaoUsuarioRepositores solicitacaoUsuarioRepositores;

    //salvar solicitacao
    public SolicitacaoUsuario criar(SolicitacaoUsuario solicitacaoUsuario){
        return solicitacaoUsuarioRepositores.save(solicitacaoUsuario);
    }


     // Verifica se os inputs solicitados estão vazios
    public void salvar(SolicitacaoUsuario solicitacaoUsuario) throws SolicitacaoUsuarioInvalid {

         EnderecoPartida enderecoPartida = solicitacaoUsuario.getEnderecoPartida();
         EnderecoChegada enderecoChegada = solicitacaoUsuario.getEnderecoChegada();
        
        if (solicitacaoUsuario.getData().trim().isEmpty() || solicitacaoUsuario.getHora().trim().isEmpty()
                || solicitacaoUsuario.getResult().trim().isEmpty() || enderecoPartida.getCep().trim().isEmpty() || enderecoPartida.getLogradouro().trim().isEmpty() || enderecoPartida.getBairro().trim().isEmpty()|| enderecoPartida.getCidade().trim().isEmpty()
               || enderecoPartida.getComplemento().trim().isEmpty() || enderecoChegada.getCep2().trim().isEmpty() || enderecoChegada.getLogradouro2().trim().isEmpty() || enderecoChegada.getBairro2().trim().isEmpty()|| enderecoChegada.getCidade2().trim().isEmpty()
               || enderecoChegada.getComplemento2().trim().isEmpty()
                ){
            throw new SolicitacaoUsuarioInvalid("Os campos obrigatórios não podem estar vazios.");
            //VALOR E COMPLEMENTOS NÃO É OBRIGATORIO
        }
        
       
        }



    
    
    
    //----------

    public List<SolicitacaoUsuario> listar(SolicitacaoUsuario solicitacaoUsuario){
        return solicitacaoUsuarioRepositores.findAll();
    }

    public String deletar(Integer id){
        solicitacaoUsuarioRepositores.deleteById(id);
        return "";
    }

    
}
