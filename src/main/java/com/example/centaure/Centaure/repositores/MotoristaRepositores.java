package com.example.centaure.Centaure.repositores;

import com.example.centaure.Centaure.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public interface MotoristaRepositores extends JpaRepository<Motorista, Integer> {

    // Método para procurar um motorista pelo endereço de e-mail
    public Optional<Motorista> findByemail(String email);

    // Métodos para verificar a existência de um motorista pelo número da CNH ou pelo e-mail
    boolean existsByCnh(String cnh);
    boolean existsByEmail(String email);

}
