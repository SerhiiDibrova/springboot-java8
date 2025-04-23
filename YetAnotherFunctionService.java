package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YetAnotherFunctionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(YetAnotherFunctionService.class);

    public String yetAnotherFunction() {
        String result = anotherFunction();
        LOGGER.info("Executed yetAnotherFunction with result: {}", result);
        return result;
    }

    private String anotherFunction() {
        return AnotherFunctionSource.anotherFunction();
    }
}