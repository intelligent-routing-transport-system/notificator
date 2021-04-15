package br.com.smartservice.notificator.notificator.services;

import br.com.smartservice.notificator.notificator.dtos.internal.PushNotificationTokenMessageDto;
import br.com.smartservice.notificator.notificator.dtos.internal.PushNotificationTopicMessageDto;
import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PushNotificationService {


    @SneakyThrows
    public BatchResponse sendMessageWithToken(PushNotificationTokenMessageDto pushNotificationTokenMessageDto) {
        MulticastMessage multicastMessage = MulticastMessage.builder()
                .setNotification(Notification.builder()
                        .setTitle(pushNotificationTokenMessageDto.getTitle())
                        .setBody(pushNotificationTokenMessageDto.getMessage())
                        .build())
                .addAllTokens(pushNotificationTokenMessageDto.getToken())
                .build();

        return FirebaseMessaging.getInstance().sendMulticast(multicastMessage);
    }

    @SneakyThrows
    public String sendMessageWithTopic(PushNotificationTopicMessageDto pushNotificationTopicMessageDto) {

        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(pushNotificationTopicMessageDto.getTitle())
                        .setBody(pushNotificationTopicMessageDto.getMessage())
                        .build())
                .setTopic(pushNotificationTopicMessageDto.getTopic())
                .build();

        return FirebaseMessaging.getInstance().send(message);
    }
}
