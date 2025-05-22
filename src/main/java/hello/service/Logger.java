package hello.service;

public class Logger {
    public void log(String message) {
        String logMessage = "[Log] " + message;
        try {
            System.out.println(logMessage);
        } catch (Exception e) {
            // Handle console output issues if necessary
        }
    }
}