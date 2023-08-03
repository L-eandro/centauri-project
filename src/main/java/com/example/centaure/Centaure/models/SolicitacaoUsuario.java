package com.example.centaure.Centaure.models;



import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class SolicitacaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String data;

    private String hora;

    private Double valor;

    private String resultado;

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String complemento;

    private String cep2;
    private String logradouro2;
    private String bairro2;
    private String cidade2;
    private String complemento2;

    




}
