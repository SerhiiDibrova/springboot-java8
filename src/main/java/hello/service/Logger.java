package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {
    private static final Logger logger = LoggerFactory.getLogger(AppLogger.class);

    public void log(String message) {
        try {
            logger.info("[Log] " + message);
        } catch (Exception e) {
            logger.error("Logging error: " + e.getMessage(), e);
        }
    }
}