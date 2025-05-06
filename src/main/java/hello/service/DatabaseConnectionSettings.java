package hello.service;

import hello.util.PostgresDsn;

public class DatabaseConnectionSettings {
    private String postgresUser;
    private String postgresPassword;
    private String postgresServer;
    private String postgresDatabase;

    public DatabaseConnectionSettings(String postgresUser, String postgresPassword, String postgresServer, String postgresDatabase) {
        setPostgresUser(postgresUser);
        setPostgresPassword(postgresPassword);
        setPostgresServer(postgresServer);
        setPostgresDatabase(postgresDatabase);
    }

    public String getPostgresUri() {
        validateFields();
        return PostgresDsn.build("postgresql", postgresUser, postgresPassword, postgresServer, "/" + postgresDatabase);
    }

    public String getPostgresUser() {
        return postgresUser;
    }

    public void setPostgresUser(String postgresUser) {
        if (postgresUser == null || postgresUser.isEmpty()) {
            throw new IllegalArgumentException("Postgres user cannot be null or empty");
        }
        this.postgresUser = postgresUser;
    }

    public String getPostgresPassword() {
        return postgresPassword;
    }

    public void setPostgresPassword(String postgresPassword) {
        if (postgresPassword == null || postgresPassword.isEmpty()) {
            throw new IllegalArgumentException("Postgres password cannot be null or empty");
        }
        this.postgresPassword = postgresPassword;
    }

    public String getPostgresServer() {
        return postgresServer;
    }

    public void setPostgresServer(String postgresServer) {
        if (postgresServer == null || postgresServer.isEmpty()) {
            throw new IllegalArgumentException("Postgres server cannot be null or empty");
        }
        this.postgresServer = postgresServer;
    }

    public String getPostgresDatabase() {
        return postgresDatabase;
    }

    public void setPostgresDatabase(String postgresDatabase) {
        if (postgresDatabase == null || postgresDatabase.isEmpty()) {
            throw new IllegalArgumentException("Postgres database cannot be null or empty");
        }
        this.postgresDatabase = postgresDatabase;
    }

    private void validateFields() {
        if (postgresUser == null || postgresUser.isEmpty() ||
            postgresPassword == null || postgresPassword.isEmpty() ||
            postgresServer == null || postgresServer.isEmpty() ||
            postgresDatabase == null || postgresDatabase.isEmpty()) {
            throw new IllegalStateException("All fields must be populated before generating the URI");
        }
    }
}