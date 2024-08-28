package ru.asayke.lifeplanningapplicationemailservice.service.implementation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.asayke.lifeplanningapplicationemailservice.exception.MessageException;
import ru.asayke.lifeplanningapplicationemailservice.service.interfaces.EmailService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailServiceImpl implements EmailService {

    final JavaMailSender mailSender;

    @Value("${mail.username}")
    private String emailUsername;

    @Override
    public void send(String recipient, String subject, String message) {
        if (recipient == null || recipient.isEmpty()) {
            throw new MessageException("Recipient can't be empty");
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(emailUsername);
        mailMessage.setTo(recipient);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
