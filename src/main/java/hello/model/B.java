package hello.model;

import org.springframework.stereotype.Component;

/**
 * This class represents the B model and contains the method_b method.
 */
@Component
public class BModel {

    /**
     * This method performs necessary operations to generate a result and returns it.
     * @return The result from method_b.
     */
    public String methodB() {
        String result = "Result from methodB";
        return result;
    }
}