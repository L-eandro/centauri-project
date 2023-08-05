package com.example.centaure.Centaure.models;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class EnderecoChegada {

   
    private String cep2;
   
    private String logradouro2;
   
    private String bairro2;
   
    private String cidade2;
  
    private String complemento2;
    
}
