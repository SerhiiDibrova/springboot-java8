package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ErrorLogRepository;
import hello.entity.ErrorLog;

@Service
public class ErrorLogService {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void logError(String errorMessage, int errorSeverity, int errorState) {
        if (errorMessage == null || errorMessage.isEmpty() || errorSeverity < 0 || errorState < 0) {
            throw new IllegalArgumentException("Invalid error parameters");
        }
        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);
        errorLogRepository.save(errorLog);
    }

    public void handleError(Exception e) {
        String errorMessage = e.getMessage();
        int errorSeverity = determineSeverity(e);
        int errorState = determineState(e);
        try {
            logError(errorMessage, errorSeverity, errorState);
        } catch (Exception logException) {
            // Log the logging exception (consider using a logger here)
        }
    }

    private int determineSeverity(Exception e) {
        if (e instanceof NullPointerException) {
            return 3;
        } else if (e instanceof IllegalArgumentException) {
            return 2;
        }
        return 1;
    }

    private int determineState(Exception e) {
        return 1; // Placeholder for state determination logic
    }
}