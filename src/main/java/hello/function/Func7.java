

package hello.function;

import java.util.InputMismatchException;

/**
 * This class provides a method to get a string value based on the input parameter.
 */
public class Func7 {

    /**
     * Returns a string value based on the input parameter.
     * 
     * @param input the input parameter
     * @return a string value based on the input parameter
     */
    public String getStringValue(Integer input) {
        if (input == null) {
            return "Input is null";
        } else if (input < 0) {
            return "Input is negative";
        } else if (input == 0) {
            return "Input is zero";
        } else {
            return "Input is positive";
        }
    }

    /**
     * Test cases to verify the functionality of the getStringValue method.
     */
    public static void main(String[] args) {
        Func7 func7 = new Func7();
        System.out.println(func7.getStringValue(10)); // Input is positive
        System.out.println(func7.getStringValue(-5)); // Input is negative
        System.out.println(func7.getStringValue(0)); // Input is zero
        System.out.println(func7.getStringValue(null)); // Input is null
        try {
            System.out.println(func7.getStringValue(Integer.parseInt("abc"))); // InputMismatchException
        } catch (NumberFormatException e) {
            System.out.println("Input is not an integer");
        }
    }
}