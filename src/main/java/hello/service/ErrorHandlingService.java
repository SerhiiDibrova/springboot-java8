package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.entity.ErrorLog;
import hello.repository.ErrorLogRepository;

@Service
public class ErrorHandlingService {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void logError(String errorMessage, Integer errorSeverity, Integer errorState) {
        if (errorMessage == null || errorSeverity == null || errorState == null) {
            return;
        }
        if (errorSeverity < 0 || errorState < 0) {
            return;
        }
        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);
        try {
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            if (!"Failed to save error log: " + e.getMessage().equals(errorMessage)) {
                logError("Failed to save error log: " + e.getMessage(), 1, 0);
            }
        }
    }
}