package hello.utility;

import hello.model.A;
import hello.model.C;
import hello.service.AnotherFunctionService;

public class UtilityFunction {

    public Object[] utilityFunction() {
        try {
            A instanceA = new A();
            C instanceC = new C();
            Object resultA = instanceA.method_a();
            Object resultC = instanceC.method_c();
            System.out.println("Using classes A and C");
            return new Object[]{resultA, resultC};
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return new Object[]{null, null};
        }
    }
}