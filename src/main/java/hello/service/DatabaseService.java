package hello.service;

import hello.service.Logger;

public class DatabaseService implements IDatabase {
    private final Logger logger;

    public DatabaseService(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void Save(String data) {
        try {
            logger.log("Saved: " + data);
        } catch (Exception e) {
            // Handle logging error
        }
    }
}