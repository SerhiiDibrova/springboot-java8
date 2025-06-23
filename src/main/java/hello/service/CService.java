package hello.service;

import hello.model.B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CService.class);

    public String methodC() {
        B b = new B();
        String result = b.b();
        LOGGER.info(result);
        System.out.println(result);
        return result;
    }
}