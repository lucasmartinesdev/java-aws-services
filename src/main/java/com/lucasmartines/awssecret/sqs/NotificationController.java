package com.lucasmartines.awssecret.sqs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationGateway notificationGateway;

    public NotificationController(NotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @PostMapping("/send/{message}")
    public void sendNotification(@PathVariable @Valid @NotBlank String message) {
        notificationGateway.sendNotification(message);
    }
}
