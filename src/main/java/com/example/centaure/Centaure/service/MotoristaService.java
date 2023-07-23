package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.repositores.MotoristaRepositores;
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
