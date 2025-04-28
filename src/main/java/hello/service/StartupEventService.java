package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StartupEventService implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger logger = LoggerFactory.getLogger("uvicorn.access");

    @Autowired
    private DatabaseConnectionSettings databaseConnectionSettings;

    @PostConstruct
    public void init() {
        try {
            String dsn = databaseConnectionSettings.getDsn();
            DatabaseConnection databaseConnection = new DatabaseConnection(dsn);
            logger.info("Database connection established: {}", dsn);
        } catch (Exception e) {
            logger.error("Error during initialization: ", e);
        }
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            // Additional startup logic can be implemented here
            logger.info("Application is ready and startup logic is executed.");
        } catch (Exception e) {
            logger.error("Error during application startup logic: ", e);
        }
    }
}