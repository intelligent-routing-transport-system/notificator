package br.com.smartservice.notificator.notificator.dtos.kafka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaBaseDto {
    private String eventName;
    private NotificatorConsumerDto payload;
    private String version;
    private String messageDate;
}
