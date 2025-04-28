package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartupListener.class);
    private final DatabaseConnectionSettings settings;

    public ApplicationStartupListener(DatabaseConnectionSettings settings) {
        this.settings = settings;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            String dsn = settings.getDsn();
            DatabaseConnection connection = new DatabaseConnection(dsn);
            logger.info("Database connection initialized successfully.");
        } catch (IllegalArgumentException e) {
            logger.error("Invalid argument during database connection initialization: ", e);
        } catch (DatabaseConnectionException e) {
            logger.error("Database connection error: ", e);
        } catch (Exception e) {
            logger.error("Unexpected error initializing database connection: ", e);
        }
    }
}