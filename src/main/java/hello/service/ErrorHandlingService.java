package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErrorHandlingService {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingService.class);

    @Transactional
    public void handleDatabaseOperation() {
        try {
            // Main logic that may generate errors goes here
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            int errorSeverity = 1;
            int errorState = 0;

            logger.error("Error occurred: {}", errorMessage);
            logger.error("Error Severity: {}", errorSeverity);
            logger.error("Error State: {}", errorState);

            // Optional: Implement logging to an error log table or other mechanisms
        }
    }
}