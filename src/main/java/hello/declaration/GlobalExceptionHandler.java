package hello.declaration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.service.ErrorHandlingService;
import org.springframework.dao.DataAccessException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final ErrorHandlingService errorHandlingService;

    public GlobalExceptionHandler(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        logger.error("An error occurred: {}", ex.getMessage(), ex);
        errorHandlingService.logError(ex.getMessage(), "ERROR");
        return new ResponseEntity<>(new ErrorResponse("An error occurred: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> handleDataAccessException(DataAccessException ex) {
        logger.error("Database error: {}", ex.getMessage(), ex);
        errorHandlingService.logError(ex.getMessage(), "ERROR");
        return new ResponseEntity<>(new ErrorResponse("Database error: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
        logger.error("Null pointer error: {}", ex.getMessage(), ex);
        errorHandlingService.logError(ex.getMessage(), "ERROR");
        return new ResponseEntity<>(new ErrorResponse("Null pointer error: " + ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    public static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}