

package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Func4Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Func4Service.class);

    public String getStringValue(Integer inputParam) {
        Assert.notNull(inputParam, "Input parameter cannot be null");
        Assert.isTrue(inputParam >= 0, "Input parameter must be a non-negative integer");
        try {
            return inputParam.toString();
        } catch (Exception e) {
            LOGGER.error("Error occurred while processing input parameter", e);
            throw new RuntimeException("Error occurred while processing input parameter", e);
        }
    }
}