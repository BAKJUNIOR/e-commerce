package ci.digitalacademyprojet.ecommerce.services.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender mailSender;


    public void sendPasswordEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Votre inscription");
        message.setText("Bienvenue ! Voici votre mot de passe : " + password);
        mailSender.send(message);
    }

    public void sendOrderConfirmationEmail(String email, String orderDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Confirmation de commande");
        message.setText("Votre commande a été finalisée. Détails : " + orderDetails);
        mailSender.send(message);
    }
}