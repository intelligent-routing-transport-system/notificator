package br.com.smartservice.notificator.notificator.dtos.internal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PushNotificationTopicMessageDto {
    private String title;
    private String message;
    private String topic;
}
