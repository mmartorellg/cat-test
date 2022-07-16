package com.cat.test.infrastructure.controller.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementExceptionsHandler(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalExceptionsHandler(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Server error ocurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
