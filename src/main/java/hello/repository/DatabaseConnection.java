package hello.repository;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

@Repository
public class DatabaseConnection {

    private Connection conn;
    private JdbcTemplate jdbcTemplate;
    private String url;
    private String username;
    private String password;

    public DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.conn = createDataSource();
        this.jdbcTemplate = createJdbcTemplate();
    }

    private Connection createDataSource() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private JdbcTemplate createJdbcTemplate() {
        return new JdbcTemplate(new DriverManagerDataSource(url, username, password));
    }

    public void close() throws SQLException {
        conn.close();
    }

    public void execute(String query, @Nullable Map<String, Object> params) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (params != null) {
                int index = 1;
                for (Object value : params.values()) {
                    pstmt.setObject(index++, value);
                }
            }
            pstmt.executeUpdate();
            conn.commit();
        }
    }

    public List<List<Object>> queryAll(String query, @Nullable Map<String, Object> params) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (params != null) {
                int index = 1;
                for (Object value : params.values()) {
                    pstmt.setObject(index++, value);
                }
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                List<List<Object>> result = new ArrayList<>();
                while (rs.next()) {
                    List<Object> row = new ArrayList<>();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        row.add(rs.getObject(i));
                    }
                    result.add(row);
                }
                return result;
            }
        }
    }

    public List<Object> queryOne(String query, @Nonnull Map<String, Object> params) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            int index = 1;
            for (Object value : params.values()) {
                pstmt.setObject(index++, value);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    List<Object> row = new ArrayList<>();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        row.add(rs.getObject(i));
                    }
                    return row;
                } else {
                    return null;
                }
            }
        }
    }
}