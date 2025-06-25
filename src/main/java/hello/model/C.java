package hello.model;

import hello.model.SomeClass;

public class C {
    public String method_c() {
        SomeClass b = new SomeClass();
        String result = b.method_b();
        System.out.println("Method C called with " + result);
        return result;
    }
}