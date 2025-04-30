package hello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DataInsertionException.class)
    public ResponseEntity<ErrorResponse> handleDataInsertionException(DataInsertionException ex) {
        logger.error("DataInsertionException occurred: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("400", ex.getMessage(), "Data insertion failed");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(XmlParsingException.class)
    public ResponseEntity<ErrorResponse> handleXmlParsingException(XmlParsingException ex) {
        logger.error("XmlParsingException occurred: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("400", ex.getMessage(), "XML parsing failed");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        logger.error("An error occurred: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("500", "An unexpected error occurred", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class ErrorResponse {
        private String errorCode;
        private String message;
        private String details;

        public ErrorResponse(String errorCode, String message, String details) {
            this.errorCode = errorCode;
            this.message = message;
            this.details = details;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }
    }
}