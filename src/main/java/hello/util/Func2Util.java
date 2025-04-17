

package hello.util;

import lombok.experimental.UtilityClass;

/**
 * Utility class providing functions for converting integers to string values.
 */
@UtilityClass
public class Func2Util {

    /**
     * Returns a string value associated with the input parameter.
     * 
     * @param input the input integer value
     * @return the string value associated with the input parameter, or "Unknown" if no match is found
     * @throws NullPointerException if the input is null
     */
    public static String getStringValue(Integer input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null");
        }
        switch (input) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            default:
                return "Unknown";
        }
    }
}