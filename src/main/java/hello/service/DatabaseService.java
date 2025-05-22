package hello.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseService {
    private Connection connection;
    private static final String DB_URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";
    private static final Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    public void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            logger.info("Database connection established.");
        } catch (SQLException e) {
            logger.error("Error connecting to database: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(String query) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query cannot be null or empty");
        }
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            logger.error("Error executing query: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                logger.info("Database connection closed.");
            }
        } catch (SQLException e) {
            logger.error("Error closing connection: {}", e.getMessage());
        }
    }
}