package hello.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.model.A;

@Component
public class B {

    private final A instanceA;

    @Autowired
    public B(A instanceA) {
        this.instanceA = instanceA;
    }

    public String method_b() {
        String result = instanceA.method_a();
        System.out.println("Method B called with " + result);
        return result;
    }
}