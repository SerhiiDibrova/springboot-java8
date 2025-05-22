package hello.service;

public class DatabaseService implements IDatabase {
    public void save(String data) {
        String message = "Saved: " + data;
        System.out.println(message);
    }
}