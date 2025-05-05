package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.repository.ErrorLogRepository;
import hello.model.ErrorLog;

@Service
public class ErrorHandlingService {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingService.class);
    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorHandlingService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    @Transactional
    public void handleDatabaseOperation() {
        try {
            // Main logic that may generate errors goes here
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            int errorSeverity = 1;
            int errorState = 0;

            logger.error("Error occurred: {}", errorMessage);
            ErrorLog errorLog = new ErrorLog(errorMessage, errorSeverity, errorState);
            errorLogRepository.save(errorLog);
        }
    }
}