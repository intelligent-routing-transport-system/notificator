package br.com.smartservice.notificator.notificator.dtos.kafka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificatorConsumerDto {
    private String[] routeIdentifier;
}
