package com.nagarro.qathon.exceptionHandler.domain;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
