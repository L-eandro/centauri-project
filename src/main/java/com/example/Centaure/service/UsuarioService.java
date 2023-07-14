package com.example.Centaure.service;

import com.example.Centaure.repositores.UsuarioRepositore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Centaure.models.Usuario;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositore usuarioRepositore;

    public Usuario criar(Usuario usuario){

        return usuarioRepositore.save(usuario);
    }
}
