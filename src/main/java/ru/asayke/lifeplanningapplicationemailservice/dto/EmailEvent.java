package ru.asayke.lifeplanningapplicationemailservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailEvent {
    String recipient;

    String title;

    String message;
}
