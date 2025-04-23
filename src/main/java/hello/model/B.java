package hello.model;

import hello.model.A;

public class B {
    public void method_b(A a) {
        if (a == null) {
            throw new NullPointerException("Class A is not properly instantiated");
        }
        if (!(a instanceof A)) {
            throw new ClassCastException("Class A is not of type A");
        }
        try {
            a.method_a();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while calling method_a", e);
        }
    }
}