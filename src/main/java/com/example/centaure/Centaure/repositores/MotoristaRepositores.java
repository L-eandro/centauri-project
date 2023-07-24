package com.example.centaure.Centaure.repositores;

import com.example.centaure.Centaure.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public interface MotoristaRepositores extends JpaRepository<Motorista, Integer> {

    boolean existsByNome(String nome);
    boolean existsByCnh(String cnh);
    boolean existsByTelefone(String telefone);
    boolean existsByData(Date data);
    boolean existsByEmail(String email);
    boolean existsBySenha(String senha);

}
