package hello;

import hello.ClassWithMethodC;
import hello.C;

public class Main {
    public static void main(String[] args) {
        try {
            ClassWithMethodC classWithMethodC = new ClassWithMethodC();
            C c = classWithMethodC.method_c();
            String result = c.method_c();
            System.out.println("Result: " + result);
            System.out.println("Main function executed.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}