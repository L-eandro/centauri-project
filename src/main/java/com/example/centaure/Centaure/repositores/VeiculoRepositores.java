package com.example.centaure.Centaure.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.example.centaure.Centaure.models.Veiculo;



@Component
public interface VeiculoRepositores extends JpaRepository<Veiculo, Integer> {

    /* 
    // Método para procurar um veículo pelo número do documento
    public Optional<Veiculo> findBydocumento(String documento);

    // Métodos para verificar a existência de um veículo pelo número do documento, pela placa e pelo nome do modelo
    boolean existsByDocumento(String documento);
    boolean existsByPlaca(String placa);
    boolean existsByNomeModelo(String nomeModelo);

    */
}
