package hello.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class CustomLogger {

    private static final Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public void log(String message) {
        try {
            String logMessage = "[Log] " + message;
            logger.info(logMessage);
        } catch (Exception e) {
            logger.error("Logging error: ", e);
        }
    }
}