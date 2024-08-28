package ru.asayke.lifeplanningapplicationemailservice.service.interfaces;

public interface EmailService {
    void send(String recipient, String subject, String message);
}
