package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseService implements IDatabase {
    private final Logger logger;

    public DatabaseService(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void save(String data) {
        if (data == null || data.isEmpty()) {
            logger.error("Invalid data provided for saving.");
            return;
        }
        try {
            logger.info("Saved: " + data);
        } catch (Exception e) {
            logger.error("Logging failed: " + e.getMessage());
        }
    }
}