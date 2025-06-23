package hello.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UtilityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityService.class);

    public String methodA() {
        LOGGER.info("Method A called");
        return "A";
    }
}