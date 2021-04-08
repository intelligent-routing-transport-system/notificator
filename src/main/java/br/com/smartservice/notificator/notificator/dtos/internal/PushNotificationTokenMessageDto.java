package br.com.smartservice.notificator.notificator.dtos.internal;

import lombok.Data;

import java.util.List;

@Data
public class PushNotificationTokenMessageDto {
    private String title;
    private String message;
    private List<String> token;
}
