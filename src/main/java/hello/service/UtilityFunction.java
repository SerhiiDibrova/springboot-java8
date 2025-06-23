package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@Service
public class UtilityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityService.class);

    public String utilityFunction() {
        try {
            LOGGER.info("Utility function called");
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                Stream<String> stream = Stream.of("Utility function result");
                stream.forEach(LOGGER::info);
            });
            executor.shutdown();
            return "Utility function result";
        } catch (Exception e) {
            LOGGER.error("Error in utility function", e);
            return null;
        }
    }

    public String utilityFunctionWithStreams() {
        try {
            LOGGER.info("Utility function with streams called");
            Stream<String> stream = Stream.of("Utility function result");
            return stream.findFirst().orElseThrow(() -> new RuntimeException("No result found"));
        } catch (Exception e) {
            LOGGER.error("Error in utility function with streams", e);
            return null;
        }
    }

    public String utilityFunctionWithLambda() {
        try {
            LOGGER.info("Utility function with lambda called");
            Stream<String> stream = Stream.of("Utility function result");
            stream.forEach(s -> LOGGER.info(s));
            return "Utility function result";
        } catch (Exception e) {
            LOGGER.error("Error in utility function with lambda", e);
            return null;
        }
    }
}