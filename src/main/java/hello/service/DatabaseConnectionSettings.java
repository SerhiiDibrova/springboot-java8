package hello.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import hello.service.PostgresDsn;

@Component
public class DatabaseConnectionSettings {

    @Value("${postgres.user}")
    private String postgresUser;

    @Value("${postgres.password}")
    private String postgresPassword;

    @Value("${postgres.server}")
    private String postgresServer;

    @Value("${postgres.database}")
    private String postgresDatabase;

    public String getPostgresUri() {
        return PostgresDsn.build("postgresql", postgresUser, postgresPassword, postgresServer, String.format("/%s", postgresDatabase));
    }
}