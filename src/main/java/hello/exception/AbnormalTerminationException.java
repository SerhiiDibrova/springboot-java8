package hello.exception;

import java.lang.RuntimeException;

public class AbnormalTerminationException extends RuntimeException {
    public AbnormalTerminationException(String message) {
        super(message);
    }
}