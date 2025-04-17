

package hello.function;

import org.springframework.stereotype.Component;

@Component
public class IntegerToStringMapper {

    public String mapIntegerToString(Integer input) {
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
                throw new IllegalArgumentException("Input is out of range");
        }
    }
}