package hello.service;

import org.springframework.stereotype.Service;

@Service
public class MethodAService {

    public String methodA() {
        System.out.println("Method A called");
        return "A";
    }
}