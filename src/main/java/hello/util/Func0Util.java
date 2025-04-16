

package hello.util;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class FunctionZeroUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionZeroUtil.class);

    public String getFunctionZeroName(Integer input) {
        if (input == null) {
            LOGGER.error("Input parameter is null");
            throw new NullPointerException("Input parameter cannot be null");
        }
        try {
            return "Name_" + input.toString();
        } catch (Exception e) {
            LOGGER.error("An error occurred during execution", e);
            throw new RuntimeException("An error occurred during execution", e);
        }
    }
}