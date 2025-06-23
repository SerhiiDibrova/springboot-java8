package hello.model;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A {
    private static final Logger logger = LoggerFactory.getLogger(A.class);

    public String methodA() {
        logger.info("Method A is called");
        return "A";
    }
}