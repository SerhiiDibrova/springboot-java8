package hello.service;

import hello.model.B;

public class CService {
    public String method_c() {
        B b = new B();
        String result = b.method_b();
        System.out.println(result);
        return result;
    }
}