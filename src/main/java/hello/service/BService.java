package hello.service;

import hello.model.A;
import org.springframework.stereotype.Service;

@Service
public class BService {

    public int method_b() {
        A instanceA = new A();
        int result = instanceA.method_a();
        System.out.println("Method B called with " + result);
        return result;
    }
}