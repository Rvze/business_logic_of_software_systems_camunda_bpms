package com.nmakarov.generalservice.exception;

public class NoSuchItemException extends RuntimeException {
    public NoSuchItemException(String message) {
        super(message);
    }
}
