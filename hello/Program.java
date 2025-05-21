package hello;

import hello.service.Logger;
import hello.service.Coordinator;

public class Program {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Coordinator coordinator = new Coordinator(logger);
        try {
            coordinator.run();
        } catch (SpecificException1 e) {
            logger.logError("Specific error occurred: " + e.getMessage());
        } catch (SpecificException2 e) {
            logger.logWarning("Warning: " + e.getMessage());
        } catch (Exception e) {
            logger.logCritical("An unexpected error occurred: " + e.getMessage());
        }
    }
}