package com.lucasmartines.awssecret.sqs;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    @Value("${spring.cloud.aws.sqs.message-queue}")
    private String queueName;

    @SqsListener("notifications-queue")
    public void consumeNotification(String message) {
        System.out.println("Received message: " + message);
    }
}
