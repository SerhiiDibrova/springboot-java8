package hello.service;

import hello.Utility;
import hello.service.AnimalService;
import hello.service.DatabaseService;
import hello.service.Logger;

public class ReportGenerator {
    private final AnimalService _animalService;
    private final DatabaseService _database;

    public ReportGenerator(AnimalService animalService, DatabaseService database) {
        this._animalService = animalService;
        this._database = database;
    }

    public void Generate() {
        try {
            String sound = _animalService.MakeSound();
            String processedData = Utility.Prepare(sound);
            _database.Save(processedData);
        } catch (NullPointerException e) {
            Logger.log("Null pointer exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            Logger.log("Illegal argument exception: " + e.getMessage());
        } catch (Exception e) {
            Logger.log("General exception: " + e.getMessage());
        }
    }
}