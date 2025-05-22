package hello.service;

import hello.model.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.service.AnimalService;
import hello.service.DatabaseService;
import hello.service.ReportGenerator;

public class Coordinator {
    private final Logger _logger;

    public Coordinator(Logger logger) {
        this._logger = logger;
    }

    public void Run() {
        _logger.info("Execution started.");
        try {
            Dog dog = new Dog();
            AnimalService animalService = new AnimalService(dog);
            DatabaseService databaseService = new DatabaseService();
            ReportGenerator reportGenerator = new ReportGenerator(animalService, databaseService);
            reportGenerator.Generate();
        } catch (Exception e) {
            _logger.error("An error occurred during execution: ", e);
        }
    }
}