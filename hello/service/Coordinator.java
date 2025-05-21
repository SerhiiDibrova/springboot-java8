package hello.service;

import hello.model.Dog;
import hello.service.AnimalService;
import hello.service.DatabaseService;
import hello.service.ReportGenerator;
import hello.service.Logger;

public class Coordinator {
    private final Logger _logger;

    public Coordinator(Logger logger) {
        this._logger = logger;
    }

    public void run() {
        _logger.log("Start");

        try {
            Dog dog = new Dog();
            AnimalService animalService = new AnimalService(dog);
            DatabaseService dbService = new DatabaseService();
            ReportGenerator reportGenerator = new ReportGenerator(animalService, dbService);
            reportGenerator.generate();

        } catch (Exception e) {
            _logger.log("Error occurred: " + e.getMessage());
        }

        _logger.log("Done");
    }
}