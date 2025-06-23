package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.service.AnotherFunction;

public class YetAnotherFunction {
    private static final Logger logger = LoggerFactory.getLogger(YetAnotherFunction.class);

    public String yetAnotherFunction() {
        AnotherFunction anotherFunction = new AnotherFunction();
        String result = anotherFunction.anotherFunction();
        logger.info("Result: {}", result);
        return result;
    }
}