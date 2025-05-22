package hello.service;

import java.util.logging.Logger;
import hello.model.Dog;
import hello.service.AnimalService;
import hello.service.DatabaseService;
import hello.service.ReportGenerator;

public class Coordinator {
    private Logger logger = Logger.getLogger(Coordinator.class.getName());

    public void run() {
        logger.info("Report generation started.");
        Dog dog = new Dog();
        AnimalService animalService = new AnimalService(dog);
        DatabaseService databaseService = new DatabaseService();
        ReportGenerator reportGenerator = new ReportGenerator(animalService, databaseService);
        reportGenerator.generate();
        logger.info("Report generation completed.");
    }
}