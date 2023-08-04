package com.example.centaure.Centaure.models;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SolicitacaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String hora;

    @Column
    private Double valor;

    @Column(nullable = false)
    private String result;

    @Column
    private EnderecoPartida enderecoPartida;

    @Column
    private EnderecoChegada enderecoChegada;

    
    @ManyToOne
    private Usuario usuario;

}
