package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ErrorLogRepository;
import hello.entity.ErrorLog;

@Service
public class ErrorHandlingService {

    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorHandlingService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void handleError(Exception e) {
        String errorMessage = e.getMessage();
        String severity = determineSeverity(e);
        String state = determineState(e);

        ErrorLog errorLog = new ErrorLog();
        errorLog.setMessage(errorMessage);
        errorLog.setSeverity(severity);
        errorLog.setState(state);

        try {
            errorLogRepository.save(errorLog);
        } catch (Exception loggingException) {
            // Handle logging failure, e.g., log to console or another logging framework
            loggingException.printStackTrace();
        }
    }

    private String determineSeverity(Exception e) {
        if (e instanceof NullPointerException) {
            return "CRITICAL";
        } else if (e instanceof IllegalArgumentException) {
            return "WARNING";
        }
        return "ERROR";
    }

    private String determineState(Exception e) {
        if (e instanceof RuntimeException) {
            return "ACTIVE";
        }
        return "INACTIVE";
    }
}