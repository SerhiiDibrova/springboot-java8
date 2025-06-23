package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

import hello.repository.ElementRepository;
import hello.entity.Element;

@Service
public class UtilityFunctionService {

    private static final Logger logger = LoggerFactory.getLogger(UtilityFunctionService.class);

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private ElementRepository elementRepository;

    @Transactional
    public String utilityFunction() {
        try {
            logger.info("Utility function started");
            Stream<String> stream = elementRepository.findAll().stream().map(Element::getName);
            String result = stream.reduce("", (a, b) -> a + b);
            logger.info("Utility function finished");
            return result;
        } catch (Exception e) {
            logger.error("Error in utility function", e);
            throw e;
        }
    }
}