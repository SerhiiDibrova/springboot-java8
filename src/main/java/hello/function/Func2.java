

package hello.function;

import java.util.HashMap;
import java.util.Map;

public class Func2 {
    private static final Map<Integer, String> nameMap = new HashMap<>();

    static {
        nameMap.put(1, "John");
        nameMap.put(2, "Alice");
        nameMap.put(3, "Bob");
    }

    public String getName(Integer input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null");
        }
        return nameMap.getOrDefault(input, "Unknown");
    }
}