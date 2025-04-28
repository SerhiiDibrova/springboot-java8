package hello.service;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Appender;
import org.apache.log4j.LogManager;

public class LoggingService {
    private static final Logger logger = Logger.getLogger(LoggingService.class);
    private static final String DEFAULT_PATTERN = "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1} - %m%n";
    private String logPattern;

    public LoggingService() {
        this.logPattern = DEFAULT_PATTERN;
        configureLogger();
    }

    public LoggingService(String logPattern) {
        this.logPattern = logPattern;
        configureLogger();
    }

    private void configureLogger() {
        try {
            PatternLayout layout = new PatternLayout(logPattern);
            ConsoleAppender consoleAppender = new ConsoleAppender(layout);
            logger.addAppender(consoleAppender);
            logger.setAdditivity(false);
        } catch (Exception e) {
            logger.error("Error configuring logger: " + e.getMessage());
        }
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logError(String message) {
        logger.error(message);
    }

    public void logDebug(String message) {
        logger.debug(message);
    }

    public void removeAppender(Appender appender) {
        logger.removeAppender(appender);
    }

    public void clearAppenders() {
        for (Appender appender : logger.getAllAppenders()) {
            logger.removeAppender(appender);
        }
    }
}