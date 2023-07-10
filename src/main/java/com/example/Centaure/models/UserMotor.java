package com.example.Centaure.models;

import lombok.*;
import javax.persistence.*;
@Data
@Entity
@Table(name = "userMotor")
public class UserMotor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String hablititacao;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
