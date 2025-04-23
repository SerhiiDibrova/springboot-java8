package hello.model;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
    public String methodA() {
        System.out.println("Method A called");
        return "A";
    }
}