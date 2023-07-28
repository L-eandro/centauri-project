package com.example.centaure.Centaure.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.example.centaure.Centaure.models.Veiculo;

@Component
public interface VeiculoRepositores extends JpaRepository<Veiculo, Integer> {
    
}
