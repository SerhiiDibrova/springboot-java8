package hello.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.controller.ErrorResponseController;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final ErrorResponseController errorResponseController;

    public GlobalExceptionHandler(ErrorResponseController errorResponseController) {
        if (errorResponseController == null) {
            throw new IllegalArgumentException("ErrorResponseController must not be null");
        }
        this.errorResponseController = errorResponseController;
    }

    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<Map<String, Object>> handleRequestValidationException(RequestValidationException ex) {
        logger.error("Request validation error: {}", ex.getMessage());
        return errorResponseController.errorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        logger.error("An error occurred: {}", ex.getMessage());
        return errorResponseController.errorResponse("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}