package com.example.demo;

public class GreetingHttpResponse {
    private final String message;

    public GreetingHttpResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
