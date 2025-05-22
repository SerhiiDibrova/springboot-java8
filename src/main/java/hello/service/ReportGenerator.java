package hello.service;

import hello.service.AnimalService;
import hello.util.Utility;
import hello.repository.DatabaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportGenerator {
    private final AnimalService _animalService;
    private final DatabaseRepository _database;
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    public ReportGenerator(AnimalService animalService, DatabaseRepository database) {
        this._animalService = animalService;
        this._database = database;
    }

    public void Generate() {
        try {
            String sound = _animalService.MakeSound();
            logger.info("Sound generated: {}", sound);
            String prepared = Utility.Prepare(sound);
            logger.info("Prepared data: {}", prepared);
            _database.Save(prepared);
            logger.info("Data saved successfully.");
        } catch (Exception e) {
            logger.error("Error occurred during report generation: {}", e.getMessage());
        }
    }
}