package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.repositores.UsuarioRepositores;

import java.util.List;
import java.util.Optional;

import extencao.UserInvalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServive {

    @Autowired
    private UsuarioRepositores usuarioRepositores;

    public static final int complexidadeSenha = 10;

    public Usuario criar(Usuario usuario) {
        return usuarioRepositores.save(usuario);

    }
    public void salvando(Usuario usuario) throws UserInvalid {
        if (usuario.getEmail().trim().isEmpty() || usuario.getNome().trim().isEmpty()
                || usuario.getCpf().trim().isEmpty() || usuario.getNumero().trim().isEmpty()) {
            throw new UserInvalid("Os campos obrigatórios não podem estar vazio.");
        }
        if (this.usuarioRepositores.existsByEmail(usuario.getEmail())
                || usuarioRepositores.existsByCpf(usuario.getCpf()) || usuarioRepositores.existsByNumero(usuario.getNumero())){
            throw new UserInvalid("Já existe um Usuário com esse atributo");
        }
    }
    public List<Usuario> listar(Usuario usuario) {
        return usuarioRepositores.findAll();
    }

    public Optional<Usuario> editar(Integer id) {
        return usuarioRepositores.findById(id);
    }

    public String deletar(Integer id) {
        usuarioRepositores.deleteById(id);
        return "";
    }

}
