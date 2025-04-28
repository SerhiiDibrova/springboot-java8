package hello.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionSettings {

    private String postgresUser;
    private String postgresPassword;
    private String postgresServer;
    private String postgresDatabase;

    public DatabaseConnectionSettings(@Value("${postgres.user}") String postgresUser,
                                      @Value("${postgres.password}") String postgresPassword,
                                      @Value("${postgres.server}") String postgresServer,
                                      @Value("${postgres.database}") String postgresDatabase) {
        if (postgresUser == null || postgresUser.isEmpty() ||
            postgresPassword == null || postgresPassword.isEmpty() ||
            postgresServer == null || postgresServer.isEmpty() ||
            postgresDatabase == null || postgresDatabase.isEmpty()) {
            throw new IllegalArgumentException("Database connection settings cannot be null or empty");
        }
        this.postgresUser = postgresUser;
        this.postgresPassword = postgresPassword;
        this.postgresServer = postgresServer;
        this.postgresDatabase = postgresDatabase;
    }

    public String getPostgresUser() {
        return postgresUser;
    }

    public String getPostgresPassword() {
        return postgresPassword;
    }

    public String getPostgresServer() {
        return postgresServer;
    }

    public String getPostgresDatabase() {
        return postgresDatabase;
    }

    public String getPostgresUri() {
        return String.format("postgresql://%s:%s@%s/%s", postgresUser, postgresPassword, postgresServer, postgresDatabase);
    }
}