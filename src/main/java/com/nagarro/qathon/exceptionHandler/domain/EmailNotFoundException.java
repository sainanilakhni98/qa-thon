package com.nagarro.qathon.exceptionHandler.domain;

public class EmailNotFoundException extends Exception {
    public EmailNotFoundException(String message) {
        super(message);
    }
}
