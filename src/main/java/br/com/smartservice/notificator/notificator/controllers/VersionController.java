package br.com.smartservice.notificator.notificator.controllers;

import br.com.smartservice.notificator.notificator.dtos.internal.VersionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("version")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VersionController {
    @GetMapping
    public ResponseEntity<VersionDto> sendPushNotificationWithToken() {
        return ResponseEntity.ok(new VersionDto("1.0.0"));
    }
}
