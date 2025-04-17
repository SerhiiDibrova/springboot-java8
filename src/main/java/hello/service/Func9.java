

package hello.service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This class provides a method to retrieve a string value associated with a given ID.
 */
public class Func9 {

    private static final Logger LOGGER = Logger.getLogger(Func9.class.getName());

    private Map<Integer, String> values = new HashMap<>();

    /**
     * Constructor to initialize the map with string values.
     */
    public Func9() {
        values.put(1, "Value 1");
        values.put(2, "Value 2");
        values.put(3, "Value 3");
    }

    /**
     * Retrieves the string value associated with the input ID.
     * 
     * @param id the input ID
     * @return the string value associated with the input ID, or null if the ID is invalid or does not exist
     */
    public String getStringValue(Integer id) {
        if (id == null) {
            LOGGER.warning("Input ID is null");
            return null;
        }

        if (!values.containsKey(id)) {
            LOGGER.warning("Input ID does not exist in the map");
            return null;
        }

        return values.get(id);
    }
}