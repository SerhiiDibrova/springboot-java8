package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErrorHandlingService {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingService.class);

    @Transactional
    public void executeWithErrorHandling(Runnable task) {
        try {
            task.run();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            int errorSeverity = 1;
            int errorState = 0;

            logger.error("Error occurred: Message: {}, Severity: {}, State: {}", errorMessage, errorSeverity, errorState);
        }
    }
}