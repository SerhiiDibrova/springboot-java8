package hello.service;

import hello.model.Dog;
import hello.service.AnimalService;
import hello.service.DatabaseService;
import hello.service.ReportGenerator;
import hello.service.LoggerService;

public class Coordinator {
    private final LoggerService loggerService;

    public Coordinator(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void Run() {
        try {
            loggerService.log("Start");
            Dog dog = new Dog();
            AnimalService animalService = new AnimalService(dog);
            DatabaseService dbService = new DatabaseService();
            ReportGenerator reportGenerator = new ReportGenerator(animalService, dbService);
            reportGenerator.Generate();
            loggerService.log("Done");
        } catch (Exception e) {
            loggerService.log("Error occurred: " + e.getMessage());
        }
    }
}