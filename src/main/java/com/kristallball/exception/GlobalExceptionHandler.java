package com.kristallball.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, 
            HttpServletRequest request) {
        
        System.err.println(">>> MISSING GET HANDLER AT: " + request.getRequestURI());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body("Method " + request.getMethod() + " is not supported for " + request.getRequestURI());
    }
}