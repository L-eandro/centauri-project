package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.repositores.UsuarioRepositores;

import java.util.List;
import java.util.Optional;

import extencao.UserInvalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServive {

    @Autowired
    private UsuarioRepositores usuarioRepositores;

    public static final int complexidadeSenha = 10;

    // Método para criptografar a senha do usuário utilizando a classe BCrypt.
    public String encryptSenha(Usuario usuario  ){
        return BCrypt.hashpw(usuario.getSenha(),BCrypt.gensalt(complexidadeSenha));
    }

    // Método para buscar um usuário pelo email e senha informados.
    public Usuario findByEmailAndSenha(String email, String senha){
        Optional<Usuario> usuario = usuarioRepositores.findByEmail(email);
        if (usuario.isPresent()){
            if (BCrypt.checkpw(senha,usuario.get().getSenha())){
                return usuario.get();
            } else{
                return null;
            }
        }else {
            return null;
        }
    }

    // Método para criar um novo usuário.
    public Usuario criar(Usuario usuario) {
        return usuarioRepositores.save(usuario);

    }

    // Método para validar e salvar um usuário, lançando exceções personalizadas em caso de campos obrigatórios vazios ou duplicação de informações.
    public void salvando(Usuario usuario) throws UserInvalid {
        if (usuario.getEmail().trim().isEmpty() || usuario.getNome().trim().isEmpty()
                || usuario.getCpf().trim().isEmpty() || usuario.getNumero().trim().isEmpty()) {
            throw new UserInvalid("Os campos obrigatórios não podem estar vazio.");
        }
        if(this.usuarioRepositores.existsByCpf(usuario.getCpf())){
            throw new UserInvalid("CPF já cadastrado");
        }
        if (this.usuarioRepositores.existsByEmail(usuario.getEmail())){
            throw new UserInvalid("Email já cadastrado");
        }
        if(this.usuarioRepositores.existsByNumero(usuario.getNumero())){
            throw new UserInvalid("Número já cadastrado");
        }
    }

    // Método para listar todos os usuários cadastrados.
    public List<Usuario> listar(Usuario usuario) {
        return usuarioRepositores.findAll();
    }

    // Método para editar um usuário pelo ID.
    public Optional<Usuario> editar(Integer id) {
        return usuarioRepositores.findById(id);
    }

    // Método para deletar um usuário pelo ID.
    public String deletar(Integer id) {
        usuarioRepositores.deleteById(id);
        return "";
    }
   public Optional<Usuario> findByEmail(String email){
        return usuarioRepositores.findByEmail(email);
   }

}