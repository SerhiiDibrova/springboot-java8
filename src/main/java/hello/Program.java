package hello;

public class Program {
    private static final Logger logger = new Logger();

    public static void main(String[] args) {
        Coordinator coordinator = new Coordinator(logger);
        try {
            coordinator.Run();
        } catch (Exception e) {
            logger.log("An error occurred: " + e.getMessage());
        }
    }
}

class Logger {
    public void log(String message) {
        System.out.println(message);
    }
}

class Coordinator {
    private Logger logger;

    public Coordinator(Logger logger) {
        this.logger = logger;
    }

    public void Run() {
        // Core business logic implementation
    }
}