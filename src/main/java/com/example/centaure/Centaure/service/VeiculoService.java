package com.example.centaure.Centaure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.centaure.Centaure.models.Veiculo;
import com.example.centaure.Centaure.repositores.VeiculoRepositores;

import extencao.MotoristaInvalid;
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

   
      // Verifica se os inputs solicitados estão vazios
    public void salvar(Veiculo veiculo) throws VeiculoInvalid {
    
        if (veiculo.getDocumento().trim().isEmpty() || veiculo.getPlaca().trim().isEmpty() ||
        veiculo.getNomeModelo().trim().isEmpty() || veiculo.getCapacidade().trim().isEmpty() ||
        veiculo.getAnoFabricacao().trim().isEmpty() || 
        veiculo.getObservacoes().trim().isEmpty() 
        
                ){
            throw new VeiculoInvalid("Os campos obrigatórios não podem estar vazios.");
            //VALOR E COMPLEMENTOS NÃO É OBRIGATORIO
        }
         if (this.veiculoRepositores.existsByDocumento(veiculo.getDocumento()) ) {
            throw new VeiculoInvalid("Documento veiculo já cadastrado!");
        } else if(this.veiculoRepositores.existsByPlaca(veiculo.getPlaca())){
            throw  new VeiculoInvalid("Placa já cadastrado!");
        }
        

    }


    public List<Veiculo> listar(Veiculo veiculo) {
        return veiculoRepositores.findAll();
    }


    public String deletar(Integer id){
        veiculoRepositores.deleteById(id);
        return "";
    }

     public Optional<Veiculo> editar(Integer id) {
        return veiculoRepositores.findById(id);
    }
  



}
