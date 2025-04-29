package hello.service;

import hello.repository.ErrorLogRepository;
import hello.entity.ErrorLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ErrorHandlingService {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingService.class);

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void handleError(String errorMessage, int errorSeverity, int errorState) {
        if (errorMessage == null || errorMessage.isEmpty()) {
            logger.error("Error message cannot be null or empty");
            return;
        }
        if (errorSeverity < 0 || errorState < 0) {
            logger.error("Error severity and state must be non-negative");
            return;
        }
        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);
        try {
            errorLogRepository.save(errorLog);
        } catch (DataAccessException e) {
            logger.error("Failed to save error log: {}", e.getMessage());
        }
        logger.error(errorMessage);
    }
}