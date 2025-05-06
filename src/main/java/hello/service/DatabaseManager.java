package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection conn;
    private static final Logger logger = LoggerFactory.getLogger(DatabaseManager.class);

    public DatabaseManager(Connection connection) {
        this.conn = connection;
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                logger.debug("Database connection closed");
            }
        } catch (SQLException e) {
            logger.error("Error closing the database connection", e);
        }
    }
}