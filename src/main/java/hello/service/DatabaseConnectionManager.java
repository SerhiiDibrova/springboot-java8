package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionManager.class);
    private Connection connection;
    private final DatabaseConnectionSettings connectionParameters;

    public DatabaseConnectionManager(DatabaseConnectionSettings connectionParameters) {
        if (connectionParameters == null) {
            throw new IllegalArgumentException("Connection parameters cannot be null");
        }
        this.connectionParameters = connectionParameters;
        initializeConnection();
    }

    private void initializeConnection() {
        try {
            connection = DriverManager.getConnection(connectionParameters.getUrl(), connectionParameters.getUsername(), connectionParameters.getPassword());
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            logger.error("Error initializing database connection", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public DatabaseConnectionManager __enter__() {
        return this;
    }

    public void __exit__(boolean hasException) {
        if (hasException) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                logger.error("Error during transaction rollback", e);
            }
        } else {
            try {
                connection.commit();
            } catch (SQLException e) {
                logger.error("Error during transaction commit", e);
            }
        }
    }

    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("Error closing database connection", e);
        }
    }
}