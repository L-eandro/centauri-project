package com.example.Centaure.models;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "vehicleregistration")
public class VehicleRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String numDocumento;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String anoFabricacao;

    @Column(nullable = false)
    private String corVeiculo;

    @Column(nullable = false)
    private Blob imagemVeiculo;

    @Column(nullable = false)
    private String observacao;


}
