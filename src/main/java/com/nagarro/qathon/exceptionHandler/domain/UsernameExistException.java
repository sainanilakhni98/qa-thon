package com.nagarro.qathon.exceptionHandler.domain;

public class UsernameExistException extends Exception {
    public UsernameExistException(String message) {
        super(message);
    }
}
