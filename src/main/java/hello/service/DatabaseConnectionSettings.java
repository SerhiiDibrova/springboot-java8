package hello.service;

import hello.util.PostgresDsn;

public class DatabaseConnectionSettings {
    private String username;
    private String password;
    private String serverAddress;
    private String databaseName;

    public DatabaseConnectionSettings(String username, String password, String serverAddress, String databaseName) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || 
            serverAddress == null || serverAddress.isEmpty() || databaseName == null || databaseName.isEmpty()) {
            throw new IllegalArgumentException("Parameters cannot be null or empty");
        }
        this.username = username;
        this.password = password;
        this.serverAddress = serverAddress;
        this.databaseName = databaseName;
    }

    public String getPostgresUri() {
        try {
            return PostgresDsn.build("postgresql", username, password, serverAddress, databaseName);
        } catch (Exception e) {
            throw new RuntimeException("Error building PostgreSQL URI", e);
        }
    }
}