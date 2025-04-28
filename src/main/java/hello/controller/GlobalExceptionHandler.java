package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        logger.error("Validation error: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> 
            errors.put(error.getObjectName(), error.getDefaultMessage()));
        return ErrorResponseUtil.errorResponse(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, String>> handleNullPointerException(NullPointerException ex) {
        logger.error("Null pointer error: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("error", "A null pointer exception occurred: " + ex.getMessage());
        return ErrorResponseUtil.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, errors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("Illegal argument error: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("error", "An illegal argument exception occurred: " + ex.getMessage());
        return ErrorResponseUtil.errorResponse(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        logger.error("An error occurred: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("error", "An unexpected error occurred: " + ex.getMessage());
        return ErrorResponseUtil.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, errors);
    }
}