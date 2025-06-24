package hello.service;

import hello.model.B;

public class C {
    public String method_c() {
        B b = new B();
        String result = b.method_b();
        System.out.println("Method C called with " + result);
        return result;
    }
}