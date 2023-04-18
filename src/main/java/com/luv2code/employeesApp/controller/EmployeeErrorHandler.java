package com.luv2code.employeesApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeErrorHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
