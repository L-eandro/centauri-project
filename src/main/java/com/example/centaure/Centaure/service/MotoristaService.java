package com.example.centaure.Centaure.service;

import com.example.centaure.Centaure.models.Motorista;

import com.example.centaure.Centaure.repositores.MotoristaRepositores;
import extencao.MotoristaInvalid;

import extencao.MotoristaNonexistentExcepition;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepositores motoristaRepositores;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JavaMailSender emailSender;


    //salvar usuario
    public Motorista criar(Motorista motorista){
        return motoristaRepositores.save(motorista);
    }

    private static final int complexidadeSenha = 10;

    // Criptografar senha
    public String criptografarSenha(Motorista motorista){
        return BCrypt.hashpw(motorista.getSenha(), BCrypt.gensalt(complexidadeSenha));
    }
    //----------


    // Referente ao login
    // busca um motorista pelo email fornecido e, se um motorista com esse email e a senha fornecida é correta
    public Motorista findByEmailAndPassword(String email, String senha){
        Optional<Motorista> motorista = motoristaRepositores.findByemail(email);
        if(motorista.isPresent()){
            if (BCrypt.checkpw(senha, motorista.get().getSenha())) {
                return motorista.get();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    //----------

    // Referente ao cadastro
    // Verifica se os inputs solicitados estão vazios
    public void salvar(Motorista motorista) throws MotoristaInvalid {
        if (motorista.getNome().trim().isEmpty() || motorista.getCnh().trim().isEmpty()
                || motorista.getCelular().trim().isEmpty() || motorista.getEmail().trim().isEmpty() ||
                motorista.getSenha().trim().isEmpty()) {
            throw new MotoristaInvalid("Os campos obrigatórios não podem estar vazio.");
        }

        // Verifica se existe dados ja cadastrados no bd
        if (this.motoristaRepositores.existsByCnh(motorista.getCnh())) {
            throw new MotoristaInvalid("CNH já cadastrada!");
        } else if(this.motoristaRepositores.existsByEmail(motorista.getEmail())){
            throw  new MotoristaInvalid("Email já cadastrado!");
        }
    }
    //----------


    // Enviar email após cadastro
    public void emailSender(Motorista motorista){

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("centauri.start@gmail.com");
            message.setTo(motorista.getEmail());
            message.setSubject("Confirmação de cadastro Centauri!");
            message.setText("Olá, " + motorista.getNome() + "."
                    + "\nSeu cadastro foi realizado com sucesso!"
                    + "\nSeja bem-vindo a centauri!"
                    + "\n\nEquipe Centauri.");

            emailSender.send(message);
        } catch (MailException e){
            e.printStackTrace();
        }

    }
    //----------

    // envia o código para o email
    public void pedidoAlterarSenha(String email) throws MotoristaNonexistentExcepition {
        Motorista motorista = motoristaRepositores.findByEmail1(email);

        if (motorista != null){
            String verificador = RandomStringUtils.randomAlphanumeric(6);
            motorista.setCodVerificar(verificador);
            motoristaRepositores.save(motorista);

            emailService.enviarPedidoAlterarSenha(email, verificador);
        } else {
            throw new MotoristaNonexistentExcepition("Email não encontrado");
        }
    }
    //----------

    // verificar se a senha do usuário e a senha de confirmação são iguais.
    public void validPassword(Motorista motorista, String passwordValid) throws MotoristaInvalid{

        if (!motorista.getSenha().equals(passwordValid)) {
            throw new MotoristaInvalid("As senhas não coincidem");
        }
    }

    // verifica se o código é valido
    public void validCod(Motorista motorista, Motorista motoristaVerificar) throws MotoristaInvalid{

        if (motorista != null) {
            if (!motorista.getCodVerificar().equals(motoristaVerificar.getCodVerificar())) {
                throw new MotoristaInvalid("Código inválido");
            }
        } else {
            throw new MotoristaInvalid("Código inválido");
        }
    }

    // Altera senha do usuário
    public void alterPassword(Motorista motorista, String senha){
        motorista.setCodVerificar(null);
        motorista.setSenha(BCrypt.hashpw(senha, BCrypt.gensalt(complexidadeSenha)));
        motoristaRepositores.save(motorista);
    }
    //----------

    public Motorista searchByCod(String cod){
        return motoristaRepositores.findByCod(cod);
    }

    public List<Motorista> listar(Motorista motorista){
        return motoristaRepositores.findAll();
    }
    public Optional<Motorista> editar(Integer id){
        return motoristaRepositores.findById(id);
    }

    public String deletar(Integer id){
        motoristaRepositores.deleteById(id);
        return "";
    }
}
