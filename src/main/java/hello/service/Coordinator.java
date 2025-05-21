package hello.service;

import java.util.logging.Logger;

public class Coordinator {
    private static final Logger _logger = Logger.getLogger(Coordinator.class.getName());

    public void Run() {
        _logger.info("Start");
        try {
            Dog dog = new Dog();
            AnimalService animalService = new AnimalService(dog);
            DatabaseService databaseService = new DatabaseService();
            ReportGenerator reportGenerator = new ReportGenerator(animalService, databaseService);
            reportGenerator.Generate();
        } catch (InstantiationException e) {
            _logger.severe("Instantiation error: " + e.getMessage());
        } catch (Exception e) {
            _logger.severe("Error occurred: " + e.getMessage());
        }
        _logger.info("Done");
    }
}

class Dog {
    // Implementation of Dog class
}

class AnimalService {
    public AnimalService(Dog dog) {
        // Implementation of AnimalService constructor
    }
}

class DatabaseService {
    // Implementation of DatabaseService class
}

class ReportGenerator {
    public ReportGenerator(AnimalService animalService, DatabaseService databaseService) {
        // Implementation of ReportGenerator constructor
    }

    public void Generate() {
        // Implementation of Generate method
    }
}