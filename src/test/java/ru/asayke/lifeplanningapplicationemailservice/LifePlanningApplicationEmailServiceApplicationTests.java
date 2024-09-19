package ru.asayke.lifeplanningapplicationemailservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import ru.asayke.lifeplanningapplicationemailservice.exception.MessageException;
import ru.asayke.lifeplanningapplicationemailservice.service.implementation.EmailServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LifePlanningApplicationEmailServiceApplicationTests {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailServiceImpl emailService;

    @Test
    void send_withEmptyRecipient_shouldThrowMessageException() {
        // Arrange
        String recipient = "";
        String subject = "Test subject";
        String message = "Test message";

        // Act & Assert
        assertThrows(MessageException.class, () -> emailService.send(recipient, subject, message));

        // Verify that send() was not called on mailSender
        verify(mailSender, never()).send(any(SimpleMailMessage.class));
    }

    @Test
    void send_withNullRecipient_shouldThrowMessageException() {
        // Arrange
        String recipient = null;
        String subject = "Test subject";
        String message = "Test message";

        // Act & Assert
        assertThrows(MessageException.class, () -> emailService.send(recipient, subject, message));

        // Verify that send() was not called on mailSender
        verify(mailSender, never()).send(any(SimpleMailMessage.class));
    }

}
