package hello.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class AppLogger {
    private static final Logger logger = LoggerFactory.getLogger(AppLogger.class);

    public void log(String message) {
        String logMessage = "[Log] " + message;
        logger.info(logMessage);
    }
}