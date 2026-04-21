package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MemberException extends RuntimeException {

    HttpStatus httpStatus;

    public MemberException() {;}

    public MemberException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
