package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ErrorLogRepository;
import hello.entity.ErrorLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;
    private static final Logger logger = LoggerFactory.getLogger(ErrorLogService.class);

    @Autowired
    public ErrorLogService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void logError(String errorMessage, String errorSeverity, String errorState) {
        if (errorMessage == null || errorMessage.isEmpty()) {
            throw new IllegalArgumentException("Error message cannot be null or empty");
        }
        if (errorSeverity == null || errorSeverity.isEmpty()) {
            throw new IllegalArgumentException("Error severity cannot be null or empty");
        }
        if (errorState == null || errorState.isEmpty()) {
            throw new IllegalArgumentException("Error state cannot be null or empty");
        }

        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);

        try {
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            logger.error("Failed to log error: {}", e.getMessage());
        }
    }
}