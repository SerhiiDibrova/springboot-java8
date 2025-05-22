package hello;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Program.class.getName());
        LoggerService loggerService = new LoggerService(logger);
        Coordinator coordinator = new Coordinator(loggerService);
        try {
            coordinator.Run();
        } catch (Exception e) {
            loggerService.log("An error occurred: " + e.getMessage());
        }
    }
}