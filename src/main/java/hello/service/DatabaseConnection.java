package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

@Service
public class DatabaseConnection {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    private final DataSource conn;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseConnection(DataSource conn, JdbcTemplate jdbcTemplate) {
        this.conn = conn;
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Establishes a database connection and returns the current instance of DatabaseConnection.
     * 
     * @return DatabaseConnection
     */
    public DatabaseConnection enter() {
        try (Connection connection = conn.getConnection()) {
            logger.debug("Database connection established.");
        } catch (SQLException e) {
            logger.error("Error establishing database connection: ", e);
        }
        return this;
    }

    /**
     * Attempts to close the database connection, logging a debug message upon success.
     */
    public void close() {
        try {
            // Closing logic if needed
            logger.debug("Database connection closed.");
        } catch (SQLException e) {
            logger.error("Error closing database connection: ", e);
        }
    }

    /**
     * Executes a SQL query with the provided parameters.
     * 
     * @param query  The SQL query to be executed.
     * @param params Optional parameters for the SQL query.
     */
    public void execute(String query, Object[] params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            jdbcTemplate.update(query, params);
        } catch (SQLException e) {
            logger.error("Error executing query: ", e);
        }
    }

    /**
     * Executes a SQL query and returns a single row of results as a Map.
     * 
     * @param query  The SQL query to be executed.
     * @param params Optional parameters for the SQL query.
     * @return Optional<Map<String, Object>>
     */
    public Optional<Map<String, Object>> queryOne(String query, Object... params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            return Optional.ofNullable(jdbcTemplate.queryForMap(query, params));
        } catch (SQLException e) {
            logger.error("Error executing query: ", e);
            return Optional.empty();
        }
    }
}