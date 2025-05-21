package hello.service;

import hello.service.LoggerService;

public class DatabaseService implements IDatabase {
    @Override
    public void Save(String data) {
        if (data == null || data.isEmpty()) {
            LoggerService.log("Error: Cannot save null or empty data.");
            return;
        }
        LoggerService.log("Saved: " + data);
    }
}