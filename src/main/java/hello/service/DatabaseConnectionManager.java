package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionManager.class);
    private final DataSource dataSource;
    private Connection connection;
    private boolean autoCommit;

    public DatabaseConnectionManager(DataSource dataSource) {
        this.dataSource = dataSource;
        this.autoCommit = false;
        try {
            this.connection = dataSource.getConnection();
            this.connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            logger.error("Error initializing database connection", e);
        }
    }

    public DatabaseConnectionManager __enter__() {
        return this;
    }

    public void __exit__(boolean exceptionOccurred) {
        try {
            if (exceptionOccurred) {
                if (!autoCommit) {
                    connection.rollback();
                }
            } else {
                if (!autoCommit) {
                    connection.commit();
                }
            }
        } catch (SQLException e) {
            logger.error("Error during transaction management", e);
        } finally {
            close();
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

    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}