package br.com.smartservice.notificator.notificator.dtos.internal;

import lombok.Data;

@Data
public class PushNotificationMessageDto {
    private String title;
    private String message;
}
