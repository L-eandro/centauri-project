package com.example.centaure.Centaure.repositores;

import com.example.centaure.Centaure.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MotoristaRepositores extends JpaRepository<Motorista, Integer> {
}
