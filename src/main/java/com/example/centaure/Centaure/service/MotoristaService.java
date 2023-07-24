package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Motorista;

import com.example.centaure.Centaure.repositores.MotoristaRepositores;
import extencao.MotoristaInvalid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepositores motoristaRepositores;

    public Motorista criar(Motorista motorista){
        return motoristaRepositores.save(motorista);
    }

    public void salvar(Motorista motorista) throws MotoristaInvalid {
        if (motorista.getNome().trim().isEmpty() || motorista.getCnh().trim().isEmpty()
                || motorista.getTelefone().trim().isEmpty() || motorista.getEmail().trim().isEmpty() ||
                motorista.getSenha().trim().isEmpty()) {
            throw new MotoristaInvalid("Os campos obrigatórios não podem estar vazio.");
        }
        if (this.motoristaRepositores.existsByNome(motorista.getNome())
                || motoristaRepositores.existsByCnh(motorista.getCnh()) || motoristaRepositores.existsByTelefone(motorista.getTelefone())
        || motoristaRepositores.existsByEmail(motorista.getEmail()) || motoristaRepositores.existsBySenha(motorista.getSenha())) {
            throw new MotoristaInvalid("Já existe um Usuário com esse atributo");
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
