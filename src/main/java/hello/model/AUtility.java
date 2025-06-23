package hello.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AUtility {
    private static final Logger logger = LoggerFactory.getLogger(AUtility.class);

    public String methodA() {
        try {
            logger.info("Logging a message from methodA");
            return "Hello from methodA";
        } catch (Exception e) {
            logger.error("An error occurred in methodA", e);
            return "An error occurred";
        }
    }
}