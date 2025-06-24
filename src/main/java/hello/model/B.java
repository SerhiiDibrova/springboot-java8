package hello.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class B {
    private static final Logger logger = LoggerFactory.getLogger(B.class);

    public String method_b() {
        logger.info("Method B started");
        String result = "Result from method B";
        logger.info("Method B finished");
        return result;
    }
}