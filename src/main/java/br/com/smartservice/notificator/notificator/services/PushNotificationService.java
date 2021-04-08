package br.com.smartservice.notificator.notificator.services;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PushNotificationService {

    private final Message.Builder messageBuilder;

    @SneakyThrows
    public void send() {
        Message message = messageBuilder.putData("teste", "teste")
                .build();

        String response = FirebaseMessaging.getInstance().send(message);

        log.info("Response from firebase: {}", response);
    }
}
