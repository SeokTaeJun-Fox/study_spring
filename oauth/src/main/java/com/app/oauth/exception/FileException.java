package com.app.oauth.exception;

import org.springframework.http.HttpStatus;

public class FileException extends RuntimeException {

    private HttpStatus httpStatus;

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
