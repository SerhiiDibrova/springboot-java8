package hello.service;

import hello.service.AnotherFunctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YetAnotherFunctionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(YetAnotherFunctionService.class);
    private final AnotherFunctionService anotherFunctionService;

    public YetAnotherFunctionService(AnotherFunctionService anotherFunctionService) {
        this.anotherFunctionService = anotherFunctionService;
    }

    public String yetAnotherFunction() {
        String result = anotherFunctionService.anotherFunction();
        LOGGER.info("YetAnotherFunctionService executed with result: {}", result);
        return result;
    }
}