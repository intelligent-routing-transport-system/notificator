package br.com.smartservice.notificator.notificator.controllers;

import br.com.smartservice.notificator.notificator.dtos.internal.ApiBaseDto;
import br.com.smartservice.notificator.notificator.dtos.internal.PushNotificationTokenMessageDto;
import br.com.smartservice.notificator.notificator.dtos.internal.PushNotificationTopicMessageDto;
import br.com.smartservice.notificator.notificator.services.PushNotificationService;
import com.google.firebase.messaging.BatchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("push-notification")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PushNotificationController {

    private final PushNotificationService pushNotificationService;

    @PostMapping("send-with-token")
    public ResponseEntity<ApiBaseDto<BatchResponse>> sendPushNotificationWithToken(@RequestBody PushNotificationTokenMessageDto pushNotificationTokenMessageDto) {
        BatchResponse response = pushNotificationService.sendMessageWithToken(pushNotificationTokenMessageDto);
        return ResponseEntity.ok(new ApiBaseDto<>(response));
    }

    @PostMapping("send-with-topic")
    public ResponseEntity<ApiBaseDto<String>> sendPushNotificationWithTopic(@RequestBody PushNotificationTopicMessageDto pushNotificationTopicMessageDto) {
        String response = pushNotificationService.sendMessageWithTopic(pushNotificationTopicMessageDto);
        return ResponseEntity.ok(new ApiBaseDto<>(response));
    }
}
