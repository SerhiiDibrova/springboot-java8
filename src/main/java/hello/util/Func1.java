

package hello.util;

import java.lang.String;

public class Func1 {
    public String getStringValue(Integer input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null");
        }
        try {
            return input.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error converting input to string", e);
        }
    }
}