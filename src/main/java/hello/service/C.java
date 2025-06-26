package hello.service;

import hello.model.B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C {
    private static final Logger logger = LoggerFactory.getLogger(C.class);

    public String method_c() {
        B b = new B();
        String result = b.method_b();
        logger.info(result);
        System.out.println(result);
        return result;
    }
}