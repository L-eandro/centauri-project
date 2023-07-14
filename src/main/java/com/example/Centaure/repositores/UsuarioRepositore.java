package com.example.Centaure.repositores;

import com.example.Centaure.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UsuarioRepositore extends JpaRepository<Usuario, Integer> {

}
