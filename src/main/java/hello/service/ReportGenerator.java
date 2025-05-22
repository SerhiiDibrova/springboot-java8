package hello.service;

import hello.Utility;
import hello.service.DatabaseService;
import hello.service.AnimalService;
import hello.service.Logger;

/**
 * ReportGenerator is responsible for generating reports by utilizing the AnimalService
 * to retrieve sounds, processing them with the Utility class, and saving the results
 * using the DatabaseService. It handles any exceptions that may occur during the
 * report generation process and logs them appropriately.
 */
public class ReportGenerator {
    private final AnimalService animalService;
    private final DatabaseService databaseService;

    public ReportGenerator(AnimalService animalService, DatabaseService databaseService) {
        this.animalService = animalService;
        this.databaseService = databaseService;
    }

    public void Generate() {
        try {
            String sound = animalService.MakeSound();
            String processedData = Utility.Prepare(sound);
            databaseService.save(processedData);
        } catch (Exception e) {
            Logger.log("Error during report generation: " + e.getMessage());
        }
    }
}