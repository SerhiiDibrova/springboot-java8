

package hello.function;

public class Func4 {
    public String executeFunc4(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        String name = "Function " + input;
        String result = "The result of function " + input + " is " + (input * input);
        return result;
    }
}