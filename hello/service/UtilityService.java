package hello.service;

import org.springframework.stereotype.Service;
import hello.model.A;
import hello.model.C;

@Service
public class UtilityService {

    public Object[] utilityFunction() {
        A a = new A();
        C c = new C();
        try {
            Object resultA = a.methodA();
            Object resultC = c.methodC();
            if (resultA == null || resultC == null) {
                throw new Exception("Results cannot be null");
            }
            return new Object[]{resultA, resultC};
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during utility function execution", e);
        }
    }
}