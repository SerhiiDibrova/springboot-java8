package hello.model;

import hello.model.B;

public class C {
    public String method_c() {
        try {
            B b = new B();
            String result = b.method_b();
            System.out.println(result);
            System.out.println("Method C called with the result");
            return result;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }
}