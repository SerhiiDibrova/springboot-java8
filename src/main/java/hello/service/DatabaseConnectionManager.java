package hello.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionManager.class);
    private Connection connection;
    private boolean autoCommit = true;

    public DatabaseConnectionManager() {
    }

    public void __init__(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(autoCommit);
    }

    public Connection getDbConnection(HttpServletRequest request) {
        if (connection == null) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Database connection is not available");
        }
        try {
            return connection;
        } catch (Exception e) {
            logger.error("Error retrieving database connection", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving database connection");
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("Error closing database connection", e);
            }
        }
    }

    public DatabaseConnectionManager __enter__() {
        return this;
    }

    public void __exit__(Exception exception) {
        if (exception != null) {
            logger.error("Exception occurred, rolling back transaction", exception);
            try {
                if (!autoCommit) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                logger.error("Error during rollback", e);
            }
        } else {
            try {
                if (!autoCommit) {
                    connection.commit();
                }
            } catch (SQLException e) {
                logger.error("Error during commit", e);
            }
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Error closing database connection", e);
            }
        }
    }
}