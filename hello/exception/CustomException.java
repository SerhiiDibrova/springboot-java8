package hello.exception;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomException(String message) {
        super(validateMessage(message));
    }

    public CustomException(String message, Throwable cause) {
        super(validateMessage(message), cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(validateMessage(message), cause, enableSuppression, writableStackTrace);
    }

    private static String validateMessage(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Error message cannot be null");
        }
        return message;
    }
}