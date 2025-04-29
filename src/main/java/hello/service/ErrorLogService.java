package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.repository.ErrorLogRepository;
import hello.entity.ErrorLog;

@Service
public class ErrorLogService {

    private static final Logger logger = LoggerFactory.getLogger(ErrorLogService.class);

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void logError(String errorMessage, int errorSeverity, int errorState) {
        if (errorMessage == null || errorMessage.isEmpty() || errorSeverity < 0 || errorState < 0) {
            logger.error("Invalid input parameters for logging error.");
            return;
        }

        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(errorMessage);
        errorLog.setErrorSeverity(errorSeverity);
        errorLog.setErrorState(errorState);

        try {
            errorLogRepository.save(errorLog);
            logger.info("Error logged successfully: {}", errorMessage);
        } catch (DataAccessException dae) {
            logger.error("Data access error while logging error: {}", dae.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error while logging error: {}", e.getMessage());
        }
    }
}