package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MethodAService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodAService.class);

    public String methodA() {
        LOGGER.info("Method A called");
        return "A";
    }
}