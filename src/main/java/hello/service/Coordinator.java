package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coordinator {
    private static final Logger _logger = LoggerFactory.getLogger(Coordinator.class);

    public void Run() {
        _logger.info("Start");
        try {
            Dog dog = new Dog();
            AnimalService animalService = new AnimalService(dog);
            DatabaseService databaseService = new DatabaseService();
            ReportGenerator reportGenerator = new ReportGenerator(animalService, databaseService);
            reportGenerator.Generate();
        } catch (Exception e) {
            _logger.error("Error during execution: ", e);
        } finally {
            _logger.info("Done");
        }
    }
}

class Dog {
    // Implementation of Dog class
}

class AnimalService {
    private Dog dog;

    public AnimalService(Dog dog) {
        this.dog = dog;
    }
    // Implementation of AnimalService class
}

class DatabaseService {
    // Implementation of DatabaseService class
}

class ReportGenerator {
    private AnimalService animalService;
    private DatabaseService databaseService;

    public ReportGenerator(AnimalService animalService, DatabaseService databaseService) {
        this.animalService = animalService;
        this.databaseService = databaseService;
    }

    public void Generate() {
        // Implementation of report generation
    }
}