package hello.service;

import hello.model.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeClass {
    private static final Logger logger = LoggerFactory.getLogger(SomeClass.class);

    public String method_b() {
        A aInstance = new A();
        String result = aInstance.method_a();
        logger.info("Method B called with {}", result);
        return result;
    }
}