package hello.model;

import hello.model.A;

public class B {
    public String method_b() {
        if (A.class.getDeclaredMethods().length == 0 || !hasMethod(A.class, "method_a")) {
            throw new RuntimeException("Class A must have method_a");
        }
        A instanceA = new A();
        String result = instanceA.method_a();
        if (result == null) {
            throw new RuntimeException("method_a in class A must return a String value");
        }
        System.out.println("Result from method_a: " + result);
        return result;
    }

    private boolean hasMethod(Class<?> clazz, String methodName) {
        for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                return true;
            }
        }
        return false;
    }
}