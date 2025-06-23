package hello.model;

import hello.model.A;

public class B {
    public String methodB() {
        A instanceA = new A();
        String result = instanceA.methodA();
        System.out.println("Method B called with " + result);
        return result;
    }
}