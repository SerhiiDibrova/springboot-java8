package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorHandlingService {
    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void logError(String errorMessage, int errorSeverity, int errorState) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);
        errorLogRepository.save(errorLog);
    }

    public void handleError(Exception e) {
        String errorMessage = e.getMessage();
        int errorSeverity = 1; // Placeholder for logic to determine severity
        int errorState = 1; // Placeholder for logic to determine state
        logError(errorMessage, errorSeverity, errorState);
    }
}