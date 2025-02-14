package com.lucasmartines.awssecret.sns;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sns")
public class SnsController {

    private TopicSender topicSender;

    public SnsController(TopicSender topicSender) {
        this.topicSender = topicSender;
    }

    @PostMapping("/send/{message}")
    public void sendNotification(@PathVariable @Valid @NotBlank String message) {
        topicSender.send(message);
    }
}
