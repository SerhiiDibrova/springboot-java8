package hello.model;

import org.springframework.stereotype.Component;

@Component
public class MethodA {
    public String method_a() {
        System.out.println("Hello from method_a");
        return "Method A";
    }
}