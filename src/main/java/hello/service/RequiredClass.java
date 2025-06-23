package hello.service;

import org.springframework.stereotype.Service;

@Service
public class RequiredClass {
    public String method() {
        return "Hello, World!";
    }
}