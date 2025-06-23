package hello.service;

import org.springframework.stereotype.Service;

@Service
public class AService {

    public String methodA() {
        System.out.println("Message from methodA");
        return "Method A executed";
    }
}