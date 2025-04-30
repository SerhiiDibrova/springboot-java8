package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ErrorHandlingService {

    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorHandlingService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    @Transactional
    public void handleError(String errorMessage, int errorSeverity, int errorState) {
        if (Objects.isNull(errorMessage) || errorMessage.isEmpty()) {
            throw new IllegalArgumentException("Error message cannot be null or empty");
        }
        if (errorSeverity < 0) {
            throw new IllegalArgumentException("Error severity cannot be negative");
        }
        if (errorState < 0) {
            throw new IllegalArgumentException("Error state cannot be negative");
        }

        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);

        try {
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            System.err.println("Error logging failed: " + e.getMessage());
            throw new RuntimeException("Error logging failed", e);
        }
    }
}