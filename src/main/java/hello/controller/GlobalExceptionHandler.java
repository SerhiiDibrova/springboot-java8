package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        String errorMessage = ex.getMessage();
        errorHandlingService.logError(errorMessage, 1, 1);
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package hello.service;

import org.springframework.stereotype.Service;

@Service
public class ErrorHandlingService {

    public void logError(String message, int severity, int state) {
        ErrorLog errorLog = new ErrorLog(message, severity, state);
        // Code to save errorLog to the database
    }
}

package hello.model;

public class ErrorLog {
    private String message;
    private int severity;
    private int state;

    public ErrorLog(String message, int severity, int state) {
        this.message = message;
        this.severity = severity;
        this.state = state;
    }

    // Getters and setters
}