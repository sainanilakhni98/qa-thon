package com.nagarro.qathon.exceptionHandler.domain;

public class EmailExistException extends Exception {
    public EmailExistException(String message) {
        super(message);
    }
}
