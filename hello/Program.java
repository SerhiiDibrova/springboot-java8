package hello;

import hello.service.Logger;
import hello.service.Coordinator;

public class Program {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Coordinator coordinator = new Coordinator(logger);
        try {
            coordinator.Run();
        } catch (Exception e) {
            logger.log("ERROR: " + e.getMessage(), "ERROR");
        }
    }
}