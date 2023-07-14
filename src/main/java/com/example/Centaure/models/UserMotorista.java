package com.example.Centaure.models;

import lombok.*;
import javax.persistence.*;
@Data
@Entity
@Table(name = "userMotorista")
public class UserMotorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String hablititacao;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;
}
