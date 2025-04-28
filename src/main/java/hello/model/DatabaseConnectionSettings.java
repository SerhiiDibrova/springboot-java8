package hello.model;

import hello.utils.PostgresDsn;

public class DatabaseConnectionSettings {
    private String postgresUser;
    private String postgresPassword;
    private String postgresServer;
    private String postgresDatabase;

    public DatabaseConnectionSettings(String postgresUser, String postgresPassword, String postgresServer, String postgresDatabase) {
        this.postgresUser = postgresUser;
        this.postgresPassword = postgresPassword;
        this.postgresServer = postgresServer;
        this.postgresDatabase = postgresDatabase;
    }

    public String getPostgresUri() {
        return PostgresDsn.build("postgresql", postgresUser, postgresPassword, postgresServer, String.format("/%s", postgresDatabase));
    }
}