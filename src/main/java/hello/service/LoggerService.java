package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerService {
    private static final Logger logger = LoggerFactory.getLogger(LoggerService.class);

    public void log(String message) {
        String logMessage = "[Log] " + message;
        logger.info(logMessage);
    }
}