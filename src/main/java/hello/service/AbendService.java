package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AbendService {

    private static final Logger logger = LoggerFactory.getLogger(AbendService.class);

    public void abendProgram(String message, int abendCode) {
        try {
            logger.error(message);
            long startTime = System.currentTimeMillis();
            cee3abdRoutine(message, abendCode, startTime);
        } catch (Exception e) {
            logger.error("An error occurred during abend program", e);
        }
    }

    private void cee3abdRoutine(String message, int abendCode, long startTime) {
        try {
            logger.error("Abend code: {}, Message: {}, Timing: {}", abendCode, message, System.currentTimeMillis() - startTime);
            cleanup();
            throw new RuntimeException("Abnormal termination with code " + abendCode);
        } catch (Exception e) {
            logger.error("An error occurred during cee3abd routine", e);
            throw e;
        }
    }

    private void cleanup() {
        try {
            // Add cleanup actions here, such as closing resources or releasing locks
            logger.info("Cleanup actions completed");
        } catch (Exception e) {
            logger.error("An error occurred during cleanup", e);
        }
    }
}