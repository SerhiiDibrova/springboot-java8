package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErrorHandlingService {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingService.class);

    @Transactional
    public void executeWithErrorHandling() {
        try {
            performDatabaseOperation();
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void performDatabaseOperation() {
        throw new RuntimeException("Simulated database error");
    }

    private void handleException(Exception e) {
        logger.error("An error occurred: {}", e.getMessage());
        String severity = determineErrorSeverity(e);
        String state = determineErrorState(e);
        logger.info("Error severity: {}, Error state: {}", severity, state);
    }

    private String determineErrorSeverity(Exception e) {
        return "HIGH";
    }

    private String determineErrorState(Exception e) {
        return "UNRECOVERABLE";
    }
}