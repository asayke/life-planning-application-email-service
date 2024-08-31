package ru.asayke.lifeplanningapplicationemailservice.service.implementation.kafka;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.asayke.lifeplanningapplicationemailservice.dto.EmailEvent;
import ru.asayke.lifeplanningapplicationemailservice.service.interfaces.EmailService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HotelConsumer {
    EmailService emailService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(EmailEvent emailEvent) {
        emailService.send(emailEvent.getRecipient(), emailEvent.getTitle(), emailEvent.getMessage());
    }
}
