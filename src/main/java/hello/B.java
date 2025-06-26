package hello;

import hello.model.A;

public class B {
    public Object method_b() {
        try {
            A a = new A();
            if (a == null) {
                throw new NullPointerException("Class A is null");
            }
            Object result = a.method_a();
            if (result == null) {
                throw new NullPointerException("Result of method_a is null");
            }
            System.out.println("Result: " + result);
            return result;
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }
}