package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<?> handleRequestValidationException(RequestValidationException ex) {
        logger.error(ex.getMessage());
        return ErrorResponseService.errorResponse(ex.getMessage(), Optional.empty(), HttpStatus.BAD_REQUEST, Optional.empty());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        logger.error(ex.getMessage());
        return ErrorResponseService.errorResponse(ex.getMessage(), Optional.empty(), HttpStatus.INTERNAL_SERVER_ERROR, Optional.empty());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> handleOrderNotFoundException(OrderNotFoundException ex) {
        return ErrorResponseService.errorResponse("Order not found", Optional.empty(), HttpStatus.NOT_FOUND, Optional.empty());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {
        return ErrorResponseService.errorResponse("User not found", Optional.empty(), HttpStatus.NOT_FOUND, Optional.empty());
    }
}