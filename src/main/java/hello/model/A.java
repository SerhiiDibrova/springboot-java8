package hello.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A {
    private static final Logger logger = LoggerFactory.getLogger(A.class);

    public String method_a() {
        logger.info("Method A called");
        System.out.println("Method A called");
        return "A";
    }
}