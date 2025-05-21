package hello.service;

import hello.model.Dog;
import hello.service.AnimalService;
import hello.service.DatabaseService;
import hello.service.ReportGenerator;
import hello.service.LoggerService;

public class Coordinator {
    private final LoggerService logger;

    public Coordinator(LoggerService logger) {
        this.logger = logger;
    }

    public void run() {
        logger.log("Start");

        try {
            Dog dog = new Dog();
            AnimalService animalService = new AnimalService(dog);
            DatabaseService dbService = new DatabaseService();

            ReportGenerator reportGenerator = new ReportGenerator(animalService, dbService);
            reportGenerator.generate();

        } catch (Exception e) {
            logger.log("Error occurred: " + e.getMessage());
        }

        logger.log("Done");
    }
}