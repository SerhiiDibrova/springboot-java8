

package hello.declaration;

import java.util.function.Callable;
import java.util.function.Function;

public class Func0 implements Callable<String> {

    @Override
    public String call() {
        return getName(0);
    }

    public String getName(Integer input) {
        if (input == null) {
            throw new NullPointerException("Input parameter cannot be null");
        }
        return "Name_" + input;
    }
}