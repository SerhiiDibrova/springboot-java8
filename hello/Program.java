package hello;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    public static void main(String[] args) {
        LoggerService logger = new LoggerService();
        Coordinator coordinator = new Coordinator(logger);
        
        try {
            coordinator.Run();
        } catch (Exception e) {
            logger.log("An error occurred: " + e.getMessage(), e);
        }
    }
}

class LoggerService {
    private static final Logger logger = Logger.getLogger(LoggerService.class.getName());

    public void log(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }

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
        logger.log("Coordinator is running.");
        // Business logic goes here
    }
}