package hello;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationEntry {
    public static void main(String[] args) {
        LoggerService logger = new LoggerService();
        Coordinator coordinator = new Coordinator(logger);
        try {
            coordinator.Run();
        } catch (Exception e) {
            logger.log(e.getMessage());
        }
    }
}

class LoggerService {
    private static final Logger logger = Logger.getLogger(LoggerService.class.getName());

    public void log(String message) {
        logger.log(Level.INFO, message);
    }
}

class Coordinator {
    private LoggerService logger;

    public Coordinator(LoggerService logger) {
        this.logger = logger;
    }

    public void Run() {
        // Core business logic implementation
        logger.log("Coordinator is running.");
        // Additional logic for handling concurrent requests can be added here
    }
}