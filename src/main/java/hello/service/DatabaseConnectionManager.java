package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionManager.class);
    private final DataSource dataSource;
    private Connection connection;
    private boolean autoCommit;

    public DatabaseConnectionManager(DataSource dataSource, boolean autoCommit) {
        this.dataSource = dataSource;
        this.autoCommit = autoCommit;
        initializeConnection();
    }

    private void initializeConnection() {
        try {
            connection = DataSourceUtils.getConnection(dataSource);
            connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            logger.error("Error initializing database connection", e);
        }
    }

    public DatabaseConnectionManager enter() {
        return this;
    }

    public void exit() {
        try {
            if (!autoCommit) {
                connection.commit();
            }
        } catch (SQLException e) {
            logger.error("Error committing transaction", e);
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                logger.error("Error rolling back transaction", rollbackEx);
            }
        } finally {
            close();
        }
    }

    public void close() {
        if (connection != null) {
            try {
                DataSourceUtils.releaseConnection(connection, dataSource);
            } catch (Exception e) {
                logger.error("Error closing database connection", e);
            }
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}