package hello.service;

import org.springframework.stereotype.Service;
import hello.service.UtilityService;

@Service
public class MyService {

    private final UtilityService utilityService;

    public MyService(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    public String methodA() {
        System.out.println("Method A executed");
        return "Method A result";
    }

    public String anotherFunction() {
        String result = utilityService.utilityFunction();
        System.out.println("Another function executed with result: " + result);
        return result;
    }
}