package hello.service;

import hello.utility.UtilityFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnotherFunctionService {

    private static final Logger logger = LoggerFactory.getLogger(AnotherFunctionService.class);

    public String anotherFunction() {
        String result = UtilityFunction.utilityFunction();
        logger.info("Executed another_function with result: {}", result);
        return result;
    }
}