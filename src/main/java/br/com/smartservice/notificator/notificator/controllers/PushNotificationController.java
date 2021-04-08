package br.com.smartservice.notificator.notificator.controllers;

import br.com.smartservice.notificator.notificator.services.PushNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("push-notification")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PushNotificationController {

    private final PushNotificationService pushNotificationService;

    @PostMapping("send")
    public void sendPushNotification() {
        pushNotificationService.send();
    }
}
