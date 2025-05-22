package hello.service;

import hello.Utility;
import hello.service.AnimalService;
import hello.repository.DatabaseInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportGenerator {
    private final AnimalService animalService;
    private final DatabaseInterface databaseInterface;
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    public ReportGenerator(AnimalService animalService, DatabaseInterface databaseInterface) {
        this.animalService = animalService;
        this.databaseInterface = databaseInterface;
    }

    public void generate() {
        try {
            String sound = animalService.MakeSound();
            String processedData = Utility.Prepare(sound);
            databaseInterface.Save(processedData);
        } catch (Exception e) {
            logger.error("Error generating report", e);
        }
    }
}