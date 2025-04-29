package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.model.ErrorLog;

@Service
public class ErrorHandlingService {

    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorHandlingService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void logError(String errorMessage, int errorSeverity, int errorState) {
        if (errorMessage == null || errorMessage.isEmpty() || errorSeverity < 0 || errorState < 0) {
            throw new IllegalArgumentException("Invalid error parameters");
        }
        ErrorLog errorLog = new ErrorLog();
        errorLog.setMessage(errorMessage);
        errorLog.setSeverity(errorSeverity);
        errorLog.setState(errorState);
        errorLogRepository.save(errorLog);
    }

    public void handleError(Exception exception) {
        String errorMessage = exception.getMessage();
        int errorSeverity = determineSeverity(exception);
        int errorState = determineState(exception);
        logError(errorMessage, errorSeverity, errorState);
        System.err.println("Error occurred: " + errorMessage + " | Severity: " + errorSeverity + " | State: " + errorState);
    }

    private int determineSeverity(Exception exception) {
        // Logic to determine severity based on exception type
        return 1; // Default severity
    }

    private int determineState(Exception exception) {
        // Logic to determine state based on exception type
        return 0; // Default state
    }
}