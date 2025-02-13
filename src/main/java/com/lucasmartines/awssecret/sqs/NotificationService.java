package com.lucasmartines.awssecret.sqs;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements NotificationGateway {
    @Value("${spring.cloud.aws.sqs.message-queue}")
    private String queueName;

    private final SqsTemplate sqsTemplate;


    public NotificationService(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    @Override
    public void sendNotification(String message) {
            sqsTemplate.sendAsync(queueName, message);
    }
}
