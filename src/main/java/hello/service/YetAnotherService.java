package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.service.MyService;
import hello.service.AnotherService;

@Service
public class YetAnotherService {

    private final MyService myService;
    private final AnotherService anotherService;

    @Autowired
    public YetAnotherService(MyService myService, AnotherService anotherService) {
        this.myService = myService;
        this.anotherService = anotherService;
    }

    public Object yetAnotherFunction() {
        try {
            Object result = myService.another_function();
            System.out.println("Result from MyService: " + result);
            return result;
        } catch (Exception e) {
            try {
                Object result = anotherService.another_function();
                System.out.println("Result from AnotherService: " + result);
                return result;
            } catch (Exception ex) {
                System.out.println("Error occurred: " + ex.getMessage());
                return null;
            }
        }
    }
}