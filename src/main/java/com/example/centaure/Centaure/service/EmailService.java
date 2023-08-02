package com.example.centaure.Centaure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    // Método para enviar e-mails
    public void enviarPedidoAlterarSenha(String destino, String verificador){

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("centauri.start@gmail.com");
            message.setTo(destino);
            message.setSubject("Redefinição de senha");
            message.setText("Para redefinir sua senha digite o código: " + verificador);

            javaMailSender.send(message);

        } catch (MailException e) {
            e.printStackTrace();
        }
        }
    }

