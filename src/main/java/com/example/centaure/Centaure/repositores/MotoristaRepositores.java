package com.example.centaure.Centaure.repositores;

import com.example.centaure.Centaure.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public interface MotoristaRepositores extends JpaRepository<Motorista, Integer> {

    public Optional<Motorista> findByemail(String email);


    boolean existsByCnh(String cnh);
    boolean existsByEmail(String email);


}
