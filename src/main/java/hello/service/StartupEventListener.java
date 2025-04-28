package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

@Component
public class StartupEventListener implements ApplicationListener<ApplicationReadyEvent> {
    private final Logger logger = LoggerFactory.getLogger("uvicorn.access");
    private DatabaseConnection databaseConnection;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            SimpleFormatter formatter = new SimpleFormatter() {
                @Override
                public String format(java.util.logging.LogRecord record) {
                    return String.format("%s [%s] %s%n", 
                        new java.util.Date(record.getMillis()), 
                        record.getLevel(), 
                        record.getMessage());
                }
            };
            consoleHandler.setFormatter(formatter);
            java.util.logging.Logger.getLogger("").addHandler(consoleHandler);
        } catch (Exception e) {
            logger.error("Error setting up logger: ", e);
        }

        try {
            String dsn = settings.getDbConnection().getPostgresUri();
            databaseConnection = new DatabaseConnection(dsn);
        } catch (Exception e) {
            logger.error("Error initializing database connection: ", e);
        }
    }
}