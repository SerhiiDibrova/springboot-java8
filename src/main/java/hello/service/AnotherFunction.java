package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

@Service
public class AnotherFunction {

    private static final Logger logger = LoggerFactory.getLogger(AnotherFunction.class);

    private final UtilityFunction utilityFunction;

    @Autowired
    public AnotherFunction(UtilityFunction utilityFunction) {
        this.utilityFunction = utilityFunction;
    }

    public int anotherFunction() {
        try {
            ExecutorService executor = new ThreadPoolTaskExecutor();
            int result = executor.submit(() -> utilityFunction.utilityFunction()).get();
            logger.info("Another function executed with the value of {}", result);
            Stream.of(result).forEach(r -> logger.info("Result value: {}", r));
            return result;
        } catch (Exception e) {
            logger.error("Error executing anotherFunction", e);
            throw new RuntimeException(e);
        }
    }
}