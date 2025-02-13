package com.lucasmartines.awssecret.sqs;

public interface NotificationGateway {

    void sendNotification(String message);
}
