package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DatabaseConnection implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    private Connection conn;

    public DatabaseConnection(DataSource dataSource) throws SQLException {
        this.conn = dataSource.getConnection();
        this.conn.setAutoCommit(false);
    }

    public DatabaseConnection enter() {
        return this;
    }

    public void execute(String query, Object[] params) {
        logger.info("Executing query: {}", query);
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error executing query: {}", e.getMessage());
        }
    }

    public Optional<Map<String, Object>> query_one(String query, Optional<Object[]> params) {
        logger.info("Executing query: {}", query);
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (params.isPresent()) {
                Object[] parameters = params.get();
                for (int i = 0; i < parameters.length; i++) {
                    pstmt.setObject(i + 1, parameters[i]);
                }
            }
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Map<String, Object> result = new HashMap<>();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    result.put(metaData.getColumnName(i), rs.getObject(i));
                }
                return Optional.of(result);
            }
        } catch (SQLException e) {
            logger.error("Error executing query: {}", e.getMessage());
        }
        return Optional.empty();
    }

    public void commit() {
        try {
            conn.commit();
        } catch (SQLException e) {
            logger.error("Error committing transaction: {}", e.getMessage());
        }
    }

    public void rollback() {
        try {
            conn.rollback();
        } catch (SQLException e) {
            logger.error("Error rolling back transaction: {}", e.getMessage());
        }
    }

    public void exit(Class<?> exc_type, Throwable exc, Object tb) {
        if (exc != null) {
            logger.error("Exception occurred: {}", exc.getMessage());
            rollback();
        } else {
            commit();
        }
        close();
    }

    @Override
    public void close() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error("Error closing connection: {}", e.getMessage());
            }
        }
    }
}