package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.repositores.UsuarioRepositores;

import java.util.List;
import java.util.Optional;

import extencao.UserInvalid;
import extencao.UsuarioNoExistExtencao;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServive {

    @Autowired
    private UsuarioRepositores usuarioRepositores;
    @Autowired
    private JavaMailSender emailSenderUsuario;
    @Autowired
    private EmailService emailService;

    public static final int complexidadeSenha = 10;

    // Método para criptografar a senha do usuário utilizando a classe BCrypt.
    public String encryptSenha(Usuario usuario  ){
        return BCrypt.hashpw(usuario.getSenha(),BCrypt.gensalt(complexidadeSenha));
    }

    // Método para buscar um usuário pelo email e senha informados.
    public Usuario findByEmailAndSenha(String email, String senha){
        Optional<Usuario> usuario = usuarioRepositores.findByEmail(email);
        if (usuario.isPresent()){
            if (BCrypt.checkpw(senha,usuario.get().getSenha())){
                return usuario.get();
            } else{
                return null;
            }
        }else {
            return null;
        }
    }

    // Método para criar um novo usuário.
    public Usuario criar(Usuario usuario) {
        return usuarioRepositores.save(usuario);

    }

    // Método para validar e salvar um usuário, lançando exceções personalizadas em caso de campos obrigatórios vazios ou duplicação de informações.
    public void salvando(Usuario usuario) throws UserInvalid {
        if (usuario.getEmail().trim().isEmpty() || usuario.getNome().trim().isEmpty()
                || usuario.getCpf().trim().isEmpty() || usuario.getNumero().trim().isEmpty()) {
            throw new UserInvalid("Os campos obrigatórios não podem estar vazio.");
        }
        if(this.usuarioRepositores.existsByCpf(usuario.getCpf())){
            throw new UserInvalid("CPF já cadastrado");
        }
        if (this.usuarioRepositores.existsByEmail(usuario.getEmail())){
            throw new UserInvalid("Email já cadastrado");
        }
        if(this.usuarioRepositores.existsByNumero(usuario.getNumero())){
            throw new UserInvalid("Número já cadastrado");
        }
    }

    // Método para listar todos os usuários cadastrados.
    public List<Usuario> listar(Usuario usuario) {
        return usuarioRepositores.findAll();
    }

    public void emailSenderUsuario(Usuario usuario){

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("centauri.start@gmail.com");
            message.setTo(usuario.getEmail());
            message.setSubject("Confirmação de cadastro Usuario Centauri!");
            message.setText("Olá, " + usuario.getNome() + "."
                    + "\nSeu cadastro foi realizado com sucesso!"
                    + "\nSeja bem-vindo a centauri!"
                    + "\n\nEquipe Centauri.");

            emailSenderUsuario.send(message);
        } catch (MailException e){
            e.printStackTrace();
        }

    }
    public void pedidoAlterarSenha(String email) throws UsuarioNoExistExtencao {
        Usuario usuario = usuarioRepositores.findByEmail2(email);

        if (usuario != null){
            String verificador = RandomStringUtils.randomAlphanumeric(6);
            usuario.setCodVerificar(verificador);
            usuarioRepositores.save(usuario);

            emailService.enviarPedidoAlterarSenha(email, verificador);
        } else {
            throw new UsuarioNoExistExtencao("Email não encontrado");
        }
    }
    //----------

    // verificar se a senha do usuário e a senha de confirmação são iguais.
    public void validPassword(Usuario usuario, String passwordValid) throws UserInvalid {

        if (!usuario.getSenha().equals(passwordValid)) {
            throw new UserInvalid("As senhas não coincidem");
        }
    }

    // verifica se o código é valido
    public void validCod(Usuario usuario, Usuario usuarioVerificar) throws UserInvalid{

        if (usuario != null) {
            if (!usuario.getCodVerificar().equals(usuarioVerificar.getCodVerificar())) {
                throw new UserInvalid("Código inválido");
            }
        } else {
            throw new UserInvalid("Código inválido");
        }
    }

    // Altera senha do usuário
    public void alterPassword(Usuario usuario, String senha){
        usuario.setCodVerificar(null);
        usuario.setSenha(BCrypt.hashpw(senha, BCrypt.gensalt(complexidadeSenha)));
        usuarioRepositores.save(usuario);
    }
    public Usuario searchByCod(String cod){
        return usuarioRepositores.findByCod(cod);
    }
    // Método para editar um usuário pelo ID.
    public Optional<Usuario> editar(Integer id) {
        return usuarioRepositores.findById(id);
    }

    // Método para deletar um usuário pelo ID.
    public String deletar(Integer id) {
        usuarioRepositores.deleteById(id);
        return "";
    }

}