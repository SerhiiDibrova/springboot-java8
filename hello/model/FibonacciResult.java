

package hello.model;

import java.util.List;

/**
 * Custom object to hold the list of Fibonacci numbers and a message.
 */
public class FibonacciResult {
    private List<Integer> fibNumbers;
    private String message;

    /**
     * Constructor to initialize the object with Fibonacci numbers and a message.
     * 
     * @param fibNumbers List of Fibonacci numbers
     * @param message    Message to be stored
     */
    public FibonacciResult(List<Integer> fibNumbers, String message) {
        if (fibNumbers == null || fibNumbers.isEmpty()) {
            throw new IllegalArgumentException("Fibonacci numbers cannot be null or empty");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        this.fibNumbers = fibNumbers;
        this.message = message;
    }

    /**
     * Getter method for Fibonacci numbers.
     * 
     * @return List of Fibonacci numbers
     */
    public List<Integer> getFibNumbers() {
        return fibNumbers;
    }

    /**
     * Getter method for the message.
     * 
     * @return Message
     */
    public String getMessage() {
        return message;
    }
}