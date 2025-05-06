package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class ShutdownEventListener {

    private static final Logger logger = LoggerFactory.getLogger(ShutdownEventListener.class);

    @Autowired
    private DatabaseConnection databaseConnection;

    @PreDestroy
    public void onShutdown() {
        if (databaseConnection != null) {
            try {
                databaseConnection.close();
                logger.info("Database connection closed successfully during shutdown.");
            } catch (Exception e) {
                logger.error("Error closing database connection during shutdown", e);
            }
        } else {
            logger.warn("Database connection is null, skipping closure during shutdown.");
        }
    }
}