package hello;

import hello.model.MethodA;

public class ExampleUsage {
    public static void main(String[] args) {
        try {
            MethodA methodA = new MethodA();
            if (methodA != null) {
                methodA.method_a();
            } else {
                System.out.println("Instance creation of MethodA class failed");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}