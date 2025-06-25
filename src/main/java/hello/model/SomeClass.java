package hello.model;

public class SomeClass {
    public String method_b() {
        A a = new A();
        String result = a.method_a();
        System.out.println("Method B called with " + result);
        return result;
    }
}

class A {
    public String method_a() {
        return "Hello from method A";
    }
}