package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorLogService {
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
        int errorSeverity = 1;
        int errorState = 0;
        try {
            // Simulated SQL execution
        } catch (Exception sqlException) {
            errorMessage = sqlException.getMessage();
            errorSeverity = 2; // Example severity for SQL errors
            errorState = 1; // Example state for SQL errors
        }
        logError(errorMessage, errorSeverity, errorState);
    }
}