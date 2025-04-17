

package hello.declaration;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class Func6 {

    private static final Logger LOGGER = Logger.getLogger(Func6.class.getName();

    private Map<Integer, String> stringValues = new HashMap<>();
    private Map<Integer, String> names = new HashMap<>();

    public Func6() {
        stringValues.put(1, "String value for input 1");
        stringValues.put(2, "String value for input 2");
        names.put(1, "Name for input 1");
        names.put(2, "Name for input 2");
    }

    public String getStringValue(Integer input) {
        try {
            return stringValues.get(input);
        } catch (Exception e) {
            LOGGER.severe("Error retrieving string value: " + e.getMessage());
            return "Error occurred";
        }
    }

    public String callFunc6(Integer input) {
        try {
            return getStringValue(input);
        } catch (Exception e) {
            LOGGER.severe("Error calling Func6: " + e.getMessage());
            return "Error occurred";
        }
    }

    public String getName(Integer input) {
        try {
            return names.get(input);
        } catch (Exception e) {
            LOGGER.severe("Error retrieving name: " + e.getMessage());
            return "Error occurred";
        }
    }

    public String getDateTime() {
        try {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return currentDateTime.format(formatter);
        } catch (Exception e) {
            LOGGER.severe("Error handling date and time: " + e.getMessage());
            return "Error occurred";
        }
    }
}