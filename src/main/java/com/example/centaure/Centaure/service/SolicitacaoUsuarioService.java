package com.example.centaure.Centaure.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        if (solicitacaoUsuario.getData().trim().isEmpty() || solicitacaoUsuario.getHora().trim().isEmpty()
                || solicitacaoUsuario.getResultado().trim().isEmpty()
                ){
            throw new SolicitacaoUsuarioInvalid("Os campos obrigatórios não podem estar vazio.");
            //VALOR E COMPLEMENTOS NÃO É OBRIGATORIO
        }}
    //----------

    public List<SolicitacaoUsuario> listar(SolicitacaoUsuario solicitacaoUsuario){
        return solicitacaoUsuarioRepositores.findAll();
    }

    public String deletar(Integer id){
        solicitacaoUsuarioRepositores.deleteById(id);
        return "";
    }

    
}
