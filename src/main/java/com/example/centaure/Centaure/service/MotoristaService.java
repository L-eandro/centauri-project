package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Motorista;
import com.example.centaure.Centaure.repositores.MotoristaRepositores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
