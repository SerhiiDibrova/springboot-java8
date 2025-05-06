package hello.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
    private Connection conn;

    public DatabaseConnection(Connection conn) {
        this.conn = conn;
    }

    public List<Map<String, Object>> query_all(String query, Object[] params) {
        logger.log(Level.FINE, "Executing query: " + query + " with params: " + java.util.Arrays.toString(params));

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                List<Map<String, Object>> result = new ArrayList<>();
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    ResultSetMetaData metaData = rs.getMetaData();
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        row.put(metaData.getColumnName(i), rs.getObject(i));
                    }
                    result.add(row);
                }
                return result;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error executing query", e);
            throw new RuntimeException(e);
        }
    }
}