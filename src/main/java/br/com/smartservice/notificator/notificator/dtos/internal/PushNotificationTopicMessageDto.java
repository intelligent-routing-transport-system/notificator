package br.com.smartservice.notificator.notificator.dtos.internal;

import lombok.Data;

@Data
public class PushNotificationTopicMessageDto {
    private String title;
    private String message;
    private String topic;
}
