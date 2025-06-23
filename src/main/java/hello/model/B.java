package hello.model;

import hello.model.A;

public class B {
    public int method_b() {
        A instanceA = new A();
        int result = instanceA.method_a();
        if(result >= 0) {
            System.out.println("Method B called with " + result);
            return result;
        } else {
            System.out.println("Method B called with invalid result " + result);
            return 0;
        }
    }
}