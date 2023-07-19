package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.repositores.UsuarioRepositores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class UsuarioServive {

    @Autowired
    private UsuarioRepositores usuarioRepositores;

    public Usuario criar(Usuario usuario){
        return usuarioRepositores.save(usuario);
    }

    public List<Usuario> listar(Usuario usuario){
        return usuarioRepositores.findAll();
    }
    public Optional<Usuario> editar(Integer id){
        return usuarioRepositores.findById(id);
    }

}
