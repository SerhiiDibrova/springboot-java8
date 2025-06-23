package hello.service;

import hello.service.UtilityService;

public class AnotherService {
    private UtilityService utilityService;

    public AnotherService(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    public Object anotherFunction() {
        try {
            Object result = utilityService.utilityFunction();
            if (result != null) {
                System.out.println("Executing anotherFunction with result: " + result);
                return result;
            } else {
                System.out.println("Executing anotherFunction with null result");
                return null;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while executing anotherFunction: " + e.getMessage());
            return null;
        }
    }
}