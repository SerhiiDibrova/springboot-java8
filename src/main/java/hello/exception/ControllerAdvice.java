package hello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class DataInsertionControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(DataInsertionControllerAdvice.class);

    @ExceptionHandler(DataInsertionException.class)
    public ResponseEntity<Object> handleDataInsertionException(DataInsertionException ex) {
        logger.error("Data insertion error: {}", ex.getMessage());
        HttpStatus status = ex.isCritical() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorResponse("Error during data insertion", ex.getMessage()), status);
    }

    private static class ErrorResponse {
        private String error;
        private String message;

        public ErrorResponse(String error, String message) {
            this.error = error;
            this.message = message;
        }

        public String getError() {
            return error;
        }

        public String getMessage() {
            return message;
        }
    }
}