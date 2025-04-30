package hello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DataInsertionException extends RuntimeException {
    public DataInsertionException() {
        super();
    }

    public DataInsertionException(String message) {
        super(message);
    }

    public DataInsertionException(String message, Throwable cause) {
        super(message, cause);
    }
}

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(DataInsertionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleDataInsertionException(DataInsertionException ex) {
        return ex.getMessage();
    }
}