package com.example.centaure.Centaure.models;


import com.example.centaure.Centaure.enums.ServicoEnum;
import com.example.centaure.Centaure.enums.VeiculosEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private VeiculosEnum veiculosEnum;

    @Enumerated(EnumType.STRING)
    private ServicoEnum servicoEnum;

    @Column(nullable = false, unique = true)
    private String documento;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String nomeModelo;

    @Column(nullable = false)
    private String capacidade;

    @Column(nullable = false)
    private String anoFabricacao;

    @Column(nullable = false)
    private String cor;

    @Lob
    @Column
    private byte[]foto;

    @ManyToOne
    private Motorista motorista;


}
