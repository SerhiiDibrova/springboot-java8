package hello.service;

import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.service.DatabaseConnectionService;

@Component
public class ShutdownEventListener {

    private static final Logger logger = LoggerFactory.getLogger(ShutdownEventListener.class);
    private final DatabaseConnectionService databaseConnectionService;

    public ShutdownEventListener(DatabaseConnectionService databaseConnectionService) {
        this.databaseConnectionService = databaseConnectionService;
    }

    /**
     * This method is called when the application context is being closed.
     * It is responsible for closing the database connection to ensure proper resource management.
     */
    @PreDestroy
    public void shutdownEvent() {
        try {
            logger.info("Shutting down application, closing database connection.");
            databaseConnectionService.closeConnection();
        } catch (Exception e) {
            logger.error("Error occurred while closing the database connection: ", e);
        }
    }
}