package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ErrorLogRepository;
import hello.entity.ErrorLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Service
public class ErrorLogService {

    private static final Logger logger = LoggerFactory.getLogger(ErrorLogService.class);

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void logError(String errorMessage, Integer errorSeverity, Integer errorState) {
        if (errorMessage == null || errorMessage.isEmpty()) {
            throw new IllegalArgumentException("Error message cannot be null or empty");
        }
        if (errorSeverity == null || errorSeverity < 1 || errorSeverity > 5) {
            throw new IllegalArgumentException("Error severity must be between 1 and 5");
        }
        if (errorState == null || errorState < 0) {
            throw new IllegalArgumentException("Error state must be a non-negative integer");
        }

        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);
        errorLog.setTimestamp(LocalDateTime.now());

        try {
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            logger.error("Failed to log error: {}", e.getMessage(), e);
        }
    }
}