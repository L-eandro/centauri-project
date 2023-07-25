package com.example.centaure.Centaure.repositores;

import com.example.centaure.Centaure.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public interface MotoristaRepositores extends JpaRepository<Motorista, Integer> {

    public Motorista findByEmailAndSenha(String email, String senha);


    boolean existsByCnh(String cnh);
    boolean existsByEmail(String email);


}
