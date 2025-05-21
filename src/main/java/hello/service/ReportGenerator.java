package hello.service;

import hello.declaration.IAnimal;
import hello.service.Utility;
import hello.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportGenerator {
    private final AnimalService animalService;
    private final DatabaseService database;
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    public ReportGenerator(AnimalService animalService, DatabaseService database) {
        if (animalService == null || database == null) {
            throw new IllegalArgumentException("Dependencies cannot be null");
        }
        this.animalService = animalService;
        this.database = database;
    }

    /**
     * Generates a report based on animal sounds.
     */
    public void generate() {
        try {
            IAnimal animal = animalService.makeSound();
            String processedSound = Utility.prepare(animal.getSound());
            database.save(processedSound);
        } catch (Exception e) {
            logger.error("Error generating report", e);
        }
    }
}