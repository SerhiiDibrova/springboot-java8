package hello.dto;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorLogDTO {
    private static final Logger logger = Logger.getLogger(ErrorLogDTO.class.getName());
    private String errorMessage;
    private String errorCode;
    private LocalDateTime timestamp;

    public ErrorLogDTO(String errorMessage, String errorCode, LocalDateTime timestamp) {
        if (errorMessage == null || errorMessage.isEmpty()) {
            logger.log(Level.SEVERE, "Invalid errorMessage: " + errorMessage);
            throw new IllegalArgumentException("errorMessage cannot be null or empty");
        }
        if (errorCode == null || errorCode.isEmpty()) {
            logger.log(Level.SEVERE, "Invalid errorCode: " + errorCode);
            throw new IllegalArgumentException("errorCode cannot be null or empty");
        }
        if (timestamp == null) {
            logger.log(Level.SEVERE, "Invalid timestamp: " + timestamp);
            throw new IllegalArgumentException("timestamp cannot be null");
        }
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
        logger.log(Level.INFO, "ErrorLogDTO created: " + this);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        if (errorMessage == null || errorMessage.isEmpty()) {
            logger.log(Level.SEVERE, "Invalid errorMessage: " + errorMessage);
            throw new IllegalArgumentException("errorMessage cannot be null or empty");
        }
        this.errorMessage = errorMessage;
        logger.log(Level.INFO, "errorMessage updated: " + this);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        if (errorCode == null || errorCode.isEmpty()) {
            logger.log(Level.SEVERE, "Invalid errorCode: " + errorCode);
            throw new IllegalArgumentException("errorCode cannot be null or empty");
        }
        this.errorCode = errorCode;
        logger.log(Level.INFO, "errorCode updated: " + this);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        if (timestamp == null) {
            logger.log(Level.SEVERE, "Invalid timestamp: " + timestamp);
            throw new IllegalArgumentException("timestamp cannot be null");
        }
        this.timestamp = timestamp;
        logger.log(Level.INFO, "timestamp updated: " + this);
    }

    @Override
    public String toString() {
        return "ErrorLogDTO{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}