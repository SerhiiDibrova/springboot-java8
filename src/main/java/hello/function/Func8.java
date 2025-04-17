

package hello.function;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class that provides a method to retrieve a string value associated with a given integer input.
 */
public class IntegerToStringMapper {

    private static final Map<Integer, String> INTEGER_STRING_MAP = new HashMap<>();

    static {
        INTEGER_STRING_MAP.put(1, "one");
        INTEGER_STRING_MAP.put(2, "two");
        INTEGER_STRING_MAP.put(3, "three");
        // Add more mappings as needed
    }

    /**
     * Retrieves the string value associated with the given integer input.
     * 
     * @param input the integer input
     * @return the string value associated with the input, or null if no mapping is found
     */
    public String getStringValue(Integer input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null");
        }
        if (!INTEGER_STRING_MAP.containsKey(input)) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
        return INTEGER_STRING_MAP.get(input);
    }
}