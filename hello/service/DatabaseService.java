package hello.service;

import hello.logging.LoggerService;

public class DatabaseService implements IDatabase {
    private final LoggerService loggerService;

    public DatabaseService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void save(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty");
        }
        String message = "Saved: " + data;
        try {
            loggerService.log(message);
        } catch (Exception e) {
            // Handle logging failure
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}