package hello.model;

import org.springframework.stereotype.Component;

@Component
public class A {
    public class B {
        public String method_b() {
            try {
                return "Hello from method_b";
            } catch (Exception e) {
                throw new RuntimeException("An error occurred in method_b", e);
            }
        }
    }
}