package hello.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditDataServiceTest {
    private Connection connection;

    @BeforeEach
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        connection.createStatement().execute("CREATE TABLE audit_data (id INT PRIMARY KEY, action VARCHAR(255), timestamp TIMESTAMP)");
    }

    @Test
    public void testInsertAuditRecord_ValidData_ShouldInsertRecord() throws SQLException {
        String insertSQL = "INSERT INTO audit_data (id, action, timestamp) VALUES (?, ?, ?)";
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setInt(1, 1);
            pstmt.setString(2, "INSERT");
            pstmt.setTimestamp(3, currentTimestamp);
            pstmt.executeUpdate();
        }

        String selectSQL = "SELECT action, timestamp FROM audit_data WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                assertEquals("INSERT", rs.getString("action"));
                assertEquals(currentTimestamp, rs.getTimestamp("timestamp"));
            }
        }
    }

    @Test
    public void testRetrieveAuditData_ValidId_ShouldReturnCorrectData() throws SQLException {
        String insertSQL = "INSERT INTO audit_data (id, action, timestamp) VALUES (?, ?, ?)";
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setInt(1, 2);
            pstmt.setString(2, "UPDATE");
            pstmt.setTimestamp(3, currentTimestamp);
            pstmt.executeUpdate();
        }

        String selectSQL = "SELECT action, timestamp FROM audit_data WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setInt(1, 2);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                assertEquals("UPDATE", rs.getString("action"));
                assertEquals(currentTimestamp, rs.getTimestamp("timestamp"));
            }
        }
    }
}