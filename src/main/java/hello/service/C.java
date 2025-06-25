package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class B {
    public String method_b() {
        return "Result from method_b";
    }
}

public class C {
    private static final Logger logger = LoggerFactory.getLogger(C.class);

    public String method_c() {
        B b = new B();
        String result = b.method_b();
        logger.info("Result from method_b: {}", result);
        return result;
    }
}