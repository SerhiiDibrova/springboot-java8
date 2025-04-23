package hello.service;

import hello.model.B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnotherFunctionService {

    private final Logger logger = LoggerFactory.getLogger(AnotherFunctionService.class);
    private final B b;

    public AnotherFunctionService(B b) {
        this.b = b;
    }

    public String anotherFunction() {
        String returnValue = b.method_b();
        if (logger != null) {
            logger.info("anotherFunction executed with return value: {}", returnValue);
        }
        return returnValue;
    }
}