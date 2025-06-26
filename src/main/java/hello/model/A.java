package hello.model;

import org.springframework.stereotype.Component;

@Component
public class A {
    public String method_a(String input) {
        if (input == null || input.isEmpty()) {
            return "Invalid input";
        }
        String result = input.toUpperCase();
        return result;
    }
}