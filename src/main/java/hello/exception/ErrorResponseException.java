package hello.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponseException extends RuntimeException {
    public ErrorResponseException(String message) {
        super(message);
    }

    public ErrorResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}