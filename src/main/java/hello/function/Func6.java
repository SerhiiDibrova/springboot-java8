

package hello.function;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.InputMismatchException;

@Component
public class Func6 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Func6.class);
    private static final String INPUT_IS_NULL = "Input is null";
    private static final String INPUT_IS_NEGATIVE = "Input is negative";
    private static final String INPUT_IS_ZERO = "Input is zero";
    private static final String INPUT_IS_POSITIVE = "Input is positive";
    private static final String INPUT_IS_NOT_LONG = "Input is not a Long type";
    private static final String INPUT_IS_OUT_OF_RANGE = "Input is out of range";

    public String getStringValue(Long input) {
        if (input == null) {
            LOGGER.error(INPUT_IS_NULL);
            return INPUT_IS_NULL;
        }

        if (!(input instanceof Long)) {
            LOGGER.error(INPUT_IS_NOT_LONG);
            return INPUT_IS_NOT_LONG;
        }

        if (input < 0) {
            LOGGER.error(INPUT_IS_NEGATIVE);
            return INPUT_IS_NEGATIVE;
        }

        if (input == 0) {
            LOGGER.error(INPUT_IS_ZERO);
            return INPUT_IS_ZERO;
        }

        if (input > 100) {
            LOGGER.error(INPUT_IS_OUT_OF_RANGE);
            return INPUT_IS_OUT_OF_RANGE;
        }

        LOGGER.info(INPUT_IS_POSITIVE);
        return INPUT_IS_POSITIVE;
    }
}