package hello.service;

import hello.service.AnimalService;
import hello.service.DatabaseService;
import hello.utility.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportGenerator {
    private final AnimalService _animalService;
    private final DatabaseService _database;
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    public ReportGenerator(AnimalService animalService, DatabaseService database) {
        this._animalService = animalService;
        this._database = database;
    }

    public void Generate() {
        try {
            String sound = _animalService.MakeSound();
            String processedSound = Utility.Prepare(sound);
            _database.save(processedSound);
        } catch (Exception e) {
            logger.error("Error generating report", e);
        }
    }
}