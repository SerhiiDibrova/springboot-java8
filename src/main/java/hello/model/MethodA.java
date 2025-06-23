package hello.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodA {
    private static final Logger logger = LoggerFactory.getLogger(MethodA.class);

    public String method_a() {
        logger.info("Printing message from method_a");
        return "A";
    }
}