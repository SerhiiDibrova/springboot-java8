package hello;

import custom.logging.Logger;

public class Program {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Coordinator coordinator = new Coordinator(logger);
        try {
            coordinator.Run();
        } catch (Exception e) {
            logger.log("An error occurred: " + e.getMessage(), e);
        }
    }
}