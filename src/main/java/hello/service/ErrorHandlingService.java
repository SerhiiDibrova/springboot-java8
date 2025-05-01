package hello.service;

import hello.entity.ErrorLog;
import hello.repository.ErrorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ErrorHandlingService {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void handleError(String errorMessage, int errorSeverity, int errorState) {
        if (errorMessage == null || errorMessage.isEmpty()) {
            throw new IllegalArgumentException("Error message cannot be null or empty");
        }
        if (errorSeverity < 0) {
            throw new IllegalArgumentException("Error severity must be non-negative");
        }
        if (errorState < 0) {
            throw new IllegalArgumentException("Error state must be non-negative");
        }

        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);
        errorLog.setTimestamp(LocalDateTime.now());

        try {
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            // Handle exception (e.g., log it or rethrow it)
        }
    }
}