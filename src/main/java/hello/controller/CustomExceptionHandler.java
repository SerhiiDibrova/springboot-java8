package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
    private final ErrorController errorController;

    public CustomExceptionHandler(ErrorController errorController) {
        this.errorController = errorController;
    }

    @ExceptionHandler(RequestValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleRequestValidationException(RequestValidationException ex) {
        logger.error("Validation error: {}", ex.getMessage());
        return errorController.errorResponse(ex.getValidationErrors(), "Validation error", HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(SpecificException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleSpecificException(SpecificException ex) {
        logger.error("Specific error occurred: {}", ex.getMessage());
        return errorController.errorResponse(ex.getMessage(), "Specific error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        logger.error("An error occurred: {}", ex.getMessage());
        return errorController.errorResponse(ex.getMessage(), "An error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}