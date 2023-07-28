package com.example.centaure.Centaure.repositores;
import com.example.centaure.Centaure.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;
@Component
public interface UsuarioRepositores extends JpaRepository<Usuario, Integer> {
    public Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByNumero(String numero);
}
