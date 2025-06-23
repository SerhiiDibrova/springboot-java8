package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotherFunctionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnotherFunctionService.class);

    @Autowired
    private UtilityFunctionService utilityFunctionService;

    public String anotherFunction() {
        String result = utilityFunctionService.utilityFunction();
        LOGGER.info("Result from utilityFunction: {}", result);
        return result;
    }
}