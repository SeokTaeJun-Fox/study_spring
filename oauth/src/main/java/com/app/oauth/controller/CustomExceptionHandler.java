package com.app.oauth.controller;

import com.app.oauth.domain.dto.ApiResponseDTO;
import com.app.oauth.exception.MemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomExceptionHandler {

    @ExceptionHandler(MemberException.class)
    public void handleException(MemberException e) {
        ResponseEntity.status(e.getHttpStatus()).body(ApiResponseDTO.of(e.getMessage()));
    }
}
