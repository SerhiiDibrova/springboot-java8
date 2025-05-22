package hello.service;

import hello.declaration.IDatabase;
import hello.service.Logger;

public class DatabaseService implements IDatabase {
    public void save(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty");
        }
        String message = "Saved: " + data;
        Logger.log(message);
    }
}