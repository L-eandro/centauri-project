package com.example.centaure.Centaure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.models.Veiculo;
import com.example.centaure.Centaure.repositores.VeiculoRepositores;
import extencao.UserInvalid;
import extencao.VeiculoInvalid;

import java.util.List;
import java.util.Optional;


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
        if (veiculoRepositores.existsByDocumento(veiculo.getDocumento())) {
            throw new VeiculoInvalid("Veículo com o número de documento já cadastrado.");
        }
        if (veiculoRepositores.existsByPlaca(veiculo.getPlaca())) {
            throw new VeiculoInvalid("Veículo com a placa já cadastrada.");
        }
        if (veiculoRepositores.existsByNomeModelo(veiculo.getNomeModelo())) {
            throw new VeiculoInvalid("Veículo com o nome do modelo já cadastrado.");
        }

    }

    public Optional<Veiculo> findBydocumento(String documento) {
        return veiculoRepositores.findBydocumento(documento);
    }

    public List<Veiculo> listar() {
        return veiculoRepositores.findAll();
    }

    public Optional<Veiculo> buscarPorId(Integer id) {
        return veiculoRepositores.findById(id);
    }

    public Veiculo cadastrar(Veiculo veiculo) {
        return veiculoRepositores.save(veiculo);
    }

    public Veiculo editar(Veiculo veiculo) {
        return veiculoRepositores.save(veiculo);
    }

    public String deletar(Integer id){
        veiculoRepositores.deleteById(id);
        return "";
    }




}
