package hello.model;

public class Dog implements IAnimal {
    @Override
    public String Speak() {
        return "Woof";
    }
}

package hello.service;

import hello.model.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coordinator {
    private static final Logger logger = LoggerFactory.getLogger(Coordinator.class);

    public void Run() {
        logger.info("Start");
        try {
            Dog dog = new Dog();
            AnimalService animalService = new AnimalService(dog);
            DatabaseService databaseService = new DatabaseService();
            ReportGenerator reportGenerator = new ReportGenerator(animalService, databaseService);
            reportGenerator.Generate();
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        }
        logger.info("Done");
    }
}

package hello.service;

public class DatabaseService {
    // Implementation of DatabaseService
}