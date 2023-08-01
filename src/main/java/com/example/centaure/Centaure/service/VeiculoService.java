package com.example.centaure.Centaure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.models.Veiculo;
import com.example.centaure.Centaure.repositores.VeiculoRepositores;
import extencao.UserInvalid;
import extencao.VeiculoInvalid;


@Service
public class VeiculoService {
    
     @Autowired
    private VeiculoRepositores veiculoRepositores;

    // Método para criar um novo veículo.
      public Veiculo criar(Veiculo veiculo) {
        return veiculoRepositores.save(veiculo); // Salva o novo veículo no banco de dados.

      }

    // Método para validar e salvar um veículo, lançando exceções personalizadas em caso de campos obrigatórios vazios.
    public void salvando(Veiculo veiculo) throws VeiculoInvalid {
        if (veiculo.getDocumento().trim().isEmpty() || veiculo.getAnoFabricacao().trim().isEmpty()
                || veiculo.getCapacidade().trim().isEmpty() || veiculo.getCor().trim().isEmpty()
                || veiculo.getNomeModelo().trim().isEmpty() || veiculo.getPlaca().trim().isEmpty()) {
            throw new VeiculoInvalid("Os campos obrigatórios não podem estar vazio.");
        }

    }

}
