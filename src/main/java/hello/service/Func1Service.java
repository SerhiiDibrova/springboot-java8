

package hello.service;

import java.util.Objects;

/**
 * Service class providing functionality for string value retrieval.
 */
public class Func1Service {

    /**
     * Retrieves a string value based on the provided integer input.
     * 
     * @param input the integer input
     * @return a string value
     * @throws NullPointerException if the input is null
     */
    public String getStringValue(Integer input) {
        Objects.requireNonNull(input, "Input cannot be null");
        try {
            return "Hello, World!" + input;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving string value", e);
        }
    }
}