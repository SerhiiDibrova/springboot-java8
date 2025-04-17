

package hello.util;

/**
 * Utility class for converting integers to strings.
 */
public class IntegerToStringUtil {

    /**
     * Converts an integer to a string.
     * 
     * @param input the integer to convert
     * @return a string representation of the input integer
     * @throws IllegalArgumentException if the input is null
     */
    public String convertIntegerToString(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return String.valueOf(input);
    }

}