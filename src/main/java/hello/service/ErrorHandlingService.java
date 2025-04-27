package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ErrorHandlingService {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingService.class);

    public void handleError(Exception e) {
        String errorMessage = e.getMessage();
        int errorSeverity = determineSeverity(e);
        int errorState = determineState(e);

        logger.error("Error occurred: Message: {}, Severity: {}, State: {}", errorMessage, errorSeverity, errorState);
        additionalErrorHandlingLogic(e);
    }

    private int determineSeverity(Exception e) {
        if (e instanceof NullPointerException) {
            return 3;
        } else if (e instanceof IllegalArgumentException) {
            return 2;
        } else {
            return 1;
        }
    }

    private int determineState(Exception e) {
        if (e instanceof RuntimeException) {
            return 1;
        } else if (e instanceof Exception) {
            return 2;
        } else {
            return 0;
        }
    }

    private void additionalErrorHandlingLogic(Exception e) {
        // Additional error handling logic can be implemented here
    }
}