package com.example.Centaure.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "servicoUser")
public class ServicoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String tipoServico;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private String destinSaid;

    @Column(nullable = false)
    private String destinChegad;

    @Column(nullable = false)
    private String observacoes;

    @Column(nullable = false)
    private String statsViagem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;


}
