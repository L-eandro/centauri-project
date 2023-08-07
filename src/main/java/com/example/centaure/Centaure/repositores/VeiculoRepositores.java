package com.example.centaure.Centaure.repositores;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import com.example.centaure.Centaure.models.Veiculo;



@Component
public interface VeiculoRepositores extends JpaRepository<Veiculo, Integer> {

    
    // Método para procurar um veículo pelo número do documento
    public Optional<Veiculo> findBydocumento(String documento);

     public Optional<Veiculo> findByPlaca(String Placa);
   
    boolean existsByDocumento(String documento);
    boolean existsByPlaca(String placa);

   
    

    

   
}
