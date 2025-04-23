package hello.service;

import hello.service.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassWithMethodC {

    private final B b;

    @Autowired
    public ClassWithMethodC(B b) {
        if (b == null) {
            throw new NullPointerException("Injected instance of class B is null");
        }
        this.b = b;
    }

    public Object method_c() {
        try {
            B bInstance = new B();
            Object result = bInstance.method_b();
            if (!(result instanceof String || result instanceof Integer || result instanceof Double)) {
                throw new ClassCastException("Return type of method_b is not compatible with being printed and returned by method_c");
            }
            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }
}