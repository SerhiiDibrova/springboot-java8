package hello;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Program.class.getName());
        Coordinator coordinator = new Coordinator(logger);
        try {
            coordinator.Run();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred: ", e);
        }
    }
}