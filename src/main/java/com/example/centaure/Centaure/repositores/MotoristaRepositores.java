package com.example.centaure.Centaure.repositores;

import com.example.centaure.Centaure.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface MotoristaRepositores extends JpaRepository<Motorista, Integer> {

    // Método para procurar um motorista pelo endereço de e-mail
    public Optional<Motorista> findByemail(String email);

    // Métodos para verificar a existência de um motorista pelo número da CNH ou pelo e-mail
    boolean existsByCnh(String cnh);
    boolean existsByEmail(String email);

    @Query ("SELECT u From Motorista u WHERE u.email LIKE :email")
    Motorista findByEmail1(@Param("email") String email);

    @Query("SELECT u From Motorista u WHERE u.codVerificar LIKE :cod")
    Motorista findByCod(@Param("cod") String cod);


}
