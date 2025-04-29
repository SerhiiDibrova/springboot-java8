package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ErrorLogRepository;
import hello.entity.ErrorLog;
import java.time.LocalDateTime;

@Service
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorLogService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void logError(String message, String severity, String state) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Error message cannot be null or empty");
        }
        if (severity == null || severity.isEmpty()) {
            throw new IllegalArgumentException("Severity cannot be null or empty");
        }
        if (state == null || state.isEmpty()) {
            throw new IllegalArgumentException("State cannot be null or empty");
        }

        ErrorLog errorLog = new ErrorLog();
        errorLog.setMessage(message);
        errorLog.setSeverity(severity);
        errorLog.setState(state);
        errorLog.setTimestamp(LocalDateTime.now());
        errorLogRepository.save(errorLog);
    }
}