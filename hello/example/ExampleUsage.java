package hello.example;

import hello.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExampleUsage {

    private final UtilityService utilityService;

    @Autowired
    public ExampleUsage(UtilityService utilityService) {
        if (utilityService == null) {
            throw new NullPointerException("UtilityService cannot be null");
        }
        this.utilityService = utilityService;
    }

    public void exampleUsage() {
        try {
            String result = utilityService.utilityFunction();
            if (result != null && !result.isEmpty()) {
                System.out.println(result);
            } else {
                System.out.println("Result is empty or null");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}