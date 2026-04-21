package com.example.demo.controller;

import com.example.demo.domain.dto.ApiResponseDTO;
import com.example.demo.exception.MemberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MemberException.class)
    public ResponseEntity<ApiResponseDTO> handleException(MemberException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(ApiResponseDTO.of(e.getMessage(), e.getHttpStatus()));
    }
}
