package hello.service;

import org.springframework.stereotype.Service;

@Service
public class DatabaseConnectionSettings {
    private String user;
    private String password;
    private String server;
    private String database;

    public DatabaseConnectionSettings(String user, String password, String server, String database) {
        this.user = user;
        this.password = password;
        this.server = server;
        this.database = database;
    }

    public String getPostgresUri() {
        return PostgresDsn.build("postgresql", user, password, server, database);
    }
}

class PostgresDsn {
    public static String build(String scheme, String user, String password, String server, String database) {
        return String.format("%s://%s:%s@%s/%s", scheme, user, password, server, database);
    }
}