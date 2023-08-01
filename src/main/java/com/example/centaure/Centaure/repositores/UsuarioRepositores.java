package com.example.centaure.Centaure.repositores;
import com.example.centaure.Centaure.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;
@Component
public interface UsuarioRepositores extends JpaRepository<Usuario, Integer> {

    // Método para procurar um usuário pelo endereço de e-mail
    public Optional<Usuario> findByEmail(String email);

    // Métodos para verificar a existência de um usuário pelo endereço de e-mail, CPF e número
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByNumero(String numero);
}
