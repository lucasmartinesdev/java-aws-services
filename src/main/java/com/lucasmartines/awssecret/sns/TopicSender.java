package com.lucasmartines.awssecret.sns;

public interface TopicSender {
    void send(String message);
}
