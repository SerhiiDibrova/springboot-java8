package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseService implements IDatabase {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    public void save(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty");
        }
        try {
            String message = "Saved: " + data;
            logger.info(message);
        } catch (Exception e) {
            logger.error("Logging failed", e);
        }
    }
}