package com.example.Centaure.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String celular;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userMotorista_id")
    private UserMotorista userMotorista;

    @OneToMany(mappedBy = "user")
    private List<ServicoUser> servicos;

}
