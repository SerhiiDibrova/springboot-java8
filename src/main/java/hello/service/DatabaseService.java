package hello.service;

import hello.declaration.IDatabase;
import hello.service.Logger;

public class DatabaseService implements IDatabase {
    public void Save(String data) {
        try {
            Logger.log("Saved: " + data);
        } catch (Exception e) {
            // Handle logging failure
        }
    }
}