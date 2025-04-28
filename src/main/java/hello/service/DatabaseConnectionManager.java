package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionManager implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionManager.class);
    private final Connection connection;
    private final boolean autoCommit;
    private boolean isClosed = false;

    public DatabaseConnectionManager(DataSource dataSource, boolean autoCommit) throws SQLException {
        this.connection = dataSource.getConnection();
        this.autoCommit = autoCommit;
        this.connection.setAutoCommit(autoCommit);
    }

    public DatabaseConnectionManager __enter__() {
        return this;
    }

    public void __exit__(Class<?> excType, Throwable exc, Object tb) {
        try {
            if (exc != null) {
                logger.error("Exception occurred: {}", exc.getMessage());
                connection.rollback();
            } else if (!autoCommit) {
                connection.commit();
            }
        } catch (SQLException e) {
            logger.error("Error during transaction handling: {}", e.getMessage());
        } finally {
            close();
        }
    }

    public void close() {
        if (!isClosed) {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
                isClosed = true;
            } catch (SQLException e) {
                logger.error("Error closing connection: {}", e.getMessage());
            }
        }
    }
}