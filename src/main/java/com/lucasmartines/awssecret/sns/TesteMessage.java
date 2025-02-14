package com.lucasmartines.awssecret.sns;

public class TesteMessage {
    private String message;

    public TesteMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
