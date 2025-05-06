package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

@Service
public class StartupEventService implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StartupEventService.class);

    @Value("${database.connection.uri}")
    private String databaseUri;

    @PostConstruct
    public void init() {
        try {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());
            java.util.logging.Logger.getLogger("").addHandler(consoleHandler);
        } catch (Exception e) {
            logger.error("Error setting up logger", e);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            DataSource dataSource = createDataSource();
            logger.info("Application started and DataSource initialized");
        } catch (SQLException e) {
            logger.error("Database connection error during application startup", e);
        } catch (Exception e) {
            logger.error("Error during application startup", e);
        }
    }

    private DataSource createDataSource() throws SQLException {
        return new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                return DriverManager.getConnection(databaseUri);
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                return DriverManager.getConnection(databaseUri, username, password);
            }

            // Implement other DataSource methods as needed
        };
    }
}