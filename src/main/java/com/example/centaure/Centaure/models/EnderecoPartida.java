package com.example.centaure.Centaure.models;

import jakarta.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EnderecoPartida {

    
    
    private String cep;
  
    private String logradouro;
  
    private String bairro;
  
    private String cidade;
   
    private String complemento;

    
}
