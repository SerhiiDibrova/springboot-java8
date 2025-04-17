

package hello.function;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Component
public class Func5 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Func5.class);

    private Map<Integer, String> nameMap = new HashMap<>();

    public Func5() {
        nameMap.put(1, "John");
        nameMap.put(2, "Jane");
        // Add more names as needed
    }

    public String execute(Integer input) {
        if (input == null) {
            LOGGER.error("Input parameter is null");
            return "Unknown";
        }

        if (!nameMap.containsKey(input)) {
            LOGGER.error("Input parameter is outside the expected range");
            return "Unknown";
        }

        try {
            return nameMap.get(input);
        } catch (Exception e) {
            LOGGER.error("Error retrieving name", e);
            return "Unknown";
        }
    }
}