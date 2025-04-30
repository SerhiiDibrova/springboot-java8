package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditDataService {

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Autowired
    private Connection connection;

    @Transactional
    public void setupAuditDataTable() throws SQLException {
        String sql = "CREATE TEMPORARY TABLE #audit_data (id BIGINT PRIMARY KEY, action VARCHAR(255) NOT NULL, timestamp TIMESTAMP NOT NULL, userId BIGINT NOT NULL, details VARCHAR(255));";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    @Transactional
    public List<AuditData> insertAuditData(Integer managerId) {
        List<AuditData> auditDataList = new ArrayList<>();
        try {
            auditDataList = auditDataRepository.findByManagerIdAndType(managerId, "SALES");
        } catch (Exception e) {
            handleErrors(e);
        }
        return auditDataList;
    }

    @Transactional
    public void insertAuditData(List<AuditData> auditDataList) {
        String sql = "INSERT INTO #audit_data (action, timestamp, userId, details) VALUES (?, ?, ?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (AuditData auditData : auditDataList) {
                stmt.setString(1, auditData.getAction());
                stmt.setTimestamp(2, auditData.getTimestamp());
                stmt.setLong(3, auditData.getUserId());
                stmt.setString(4, auditData.getDetails());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            handleErrors(e);
        }
    }

    public List<AuditData> executeSelectAuditData() {
        List<AuditData> auditDataList = new ArrayList<>();
        String sql = "SELECT * FROM #audit_data;";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                AuditData auditData = new AuditData();
                auditData.setId(rs.getLong("id"));
                auditData.setAction(rs.getString("action"));
                auditData.setTimestamp(rs.getTimestamp("timestamp"));
                auditData.setUserId(rs.getLong("userId"));
                auditData.setDetails(rs.getString("details"));
                auditDataList.add(auditData);
            }
        } catch (SQLException e) {
            handleErrors(e);
        }
        return auditDataList;
    }

    @Transactional
    public void cleanupAuditDataTable() throws SQLException {
        String sql = "DROP TABLE #audit_data;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    private void handleErrors(Exception e) {
        // Log error message
    }
}