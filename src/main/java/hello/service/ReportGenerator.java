package hello.service;

import hello.service.AnimalService;
import hello.database.IDatabase;
import hello.utility.Utility;
import hello.logging.LoggerService;

public class ReportGenerator {
    private final AnimalService _animalService;
    private final IDatabase _database;
    private final LoggerService logger;

    public ReportGenerator(AnimalService animalService, IDatabase database, LoggerService logger) {
        this._animalService = animalService;
        this._database = database;
        this.logger = logger;
    }

    public void Generate() {
        try {
            String sound = _animalService.MakeSound();
            if (sound == null || sound.isEmpty()) {
                throw new IllegalArgumentException("Invalid sound received.");
            }
            String prepared = Utility.Prepare(sound);
            _database.Save(prepared);
            logger.log("Report generated successfully.");
        } catch (Exception e) {
            logger.log("Error generating report: " + e.getMessage());
        }
    }
}