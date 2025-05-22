package hello.service;

public class LoggerService {
    public void log(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        System.out.println("[Log] " + message);
    }
}