package hello.utils;

import javax.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationConfig {

    private DatabaseConnectionSettings databaseConnectionSettings;

    public DatabaseConnectionSettings getDatabaseConnectionSettings() {
        return databaseConnectionSettings;
    }

    public void setDatabaseConnectionSettings(DatabaseConnectionSettings databaseConnectionSettings) {
        this.databaseConnectionSettings = databaseConnectionSettings;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "databaseConnectionSettings=" + databaseConnectionSettings +
                '}';
    }

    public static class DatabaseConnectionSettings {
        
        @NotBlank
        private String uri;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        @Override
        public String toString() {
            return "DatabaseConnectionSettings{" +
                    "uri='" + uri + '\'' +
                    '}';
        }
    }
}