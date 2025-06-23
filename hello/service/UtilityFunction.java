package hello.service;

import hello.model.A;
import hello.model.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilityFunction {

    private static final Logger logger = LoggerFactory.getLogger(UtilityFunction.class);

    public Object[] utilityFunction() {
        try {
            A a = new A();
            C c = new C();
            logger.info("Utility function uses A and C");
            return new Object[]{a.method_a(), c.method_c()};
        } catch (Exception e) {
            logger.error("An error occurred during the execution of utilityFunction", e);
            return new Object[]{null, null};
        }
    }
}