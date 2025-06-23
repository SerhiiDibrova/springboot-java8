package hello.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.service.AnotherFunctionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class YetAnotherFunctionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(YetAnotherFunctionService.class);
    private final AnotherFunctionService anotherFunctionService;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public YetAnotherFunctionService(AnotherFunctionService anotherFunctionService) {
        this.anotherFunctionService = anotherFunctionService;
    }

    public String executeYetAnotherFunction() {
        executorService.submit(() -> {
            String result = anotherFunctionService.anotherFunction();
            LOGGER.info("yetAnotherFunction has been executed with result: {}", result);
            System.out.println("yetAnotherFunction has been executed with result: " + result);
        });
        return anotherFunctionService.anotherFunction();
    }
}