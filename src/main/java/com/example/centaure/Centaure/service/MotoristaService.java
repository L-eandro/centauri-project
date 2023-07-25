package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Motorista;

import com.example.centaure.Centaure.repositores.MotoristaRepositores;
import extencao.MotoristaInvalid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepositores motoristaRepositores;

    private static final int complexidadeSenha = 10;

    //salvar usuario
    public Motorista criar(Motorista motorista){
        return motoristaRepositores.save(motorista);
    }

    public String criptografarSenha(Motorista motorista){
        return BCrypt.hashpw(motorista.getSenha(), BCrypt.gensalt(complexidadeSenha));
    }


    public void salvar(Motorista motorista) throws MotoristaInvalid {
        if (motorista.getNome().trim().isEmpty() || motorista.getCnh().trim().isEmpty()
                || motorista.getTelefone().trim().isEmpty() || motorista.getEmail().trim().isEmpty() ||
                motorista.getSenha().trim().isEmpty()) {
            throw new MotoristaInvalid("Os campos obrigatórios não podem estar vazio.");
        }
        if (this.motoristaRepositores.existsByCnh(motorista.getCnh())) {
            throw new MotoristaInvalid("CNH já cadastrada!");
        } else if(this.motoristaRepositores.existsByEmail(motorista.getEmail())){
            throw  new MotoristaInvalid("Email já cadastrado!");
        }
    }




    public List<Motorista> listar(Motorista motorista){
        return motoristaRepositores.findAll();
    }
    public Optional<Motorista> editar(Integer id){
        return motoristaRepositores.findById(id);
    }

    public String deletar(Integer id){
        motoristaRepositores.deleteById(id);
        return "";
    }
}
