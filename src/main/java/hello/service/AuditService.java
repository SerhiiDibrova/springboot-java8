

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    @Autowired
    private DataSource dataSource;

    public List<AuditData> performAudit(Long managerId, boolean isAuditNeeded) {
        if (!isAuditNeeded) {
            return new ArrayList<>();
        }

        Long defaultManagerId = getDefaultManagerId(managerId);
        if (defaultManagerId == null) {
            throw new RuntimeException("Default manager ID is null");
        }

        List<AuditData> auditData = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            createTempTable(connection);
            insertAuditData(connection, defaultManagerId);
            auditData = retrieveAuditData(connection);
        } catch (SQLException e) {
            // Handle SQL exception
        }

        return auditData;
    }

    private Long getDefaultManagerId(Long managerId) {
        if (managerId == null) {
            // Retrieve default manager ID from database or configuration
            // For demonstration purposes, return a hardcoded value
            return 1L;
        }
        return managerId;
    }

    private void createTempTable(Connection connection) throws SQLException {
        String query = "CREATE TEMPORARY TABLE IF NOT EXISTS temp_audit_data AS SELECT * FROM audit";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
        }
    }

    private void insertAuditData(Connection connection, Long managerId) throws SQLException {
        if (managerId == null) {
            throw new RuntimeException("Manager ID is null");
        }

        String query = "INSERT INTO temp_audit_data SELECT * FROM audit_record WHERE manager_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, managerId);
            statement.execute();
        }
    }

    private List<AuditData> retrieveAuditData(Connection connection) throws SQLException {
        String query = "SELECT * FROM temp_audit_data";
        List<AuditData> auditData = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                AuditData data = new AuditData(resultSet.getLong("id"), resultSet.getLong("manager_id"));
                auditData.add(data);
            }
        }

        if (auditData.isEmpty()) {
            throw new RuntimeException("Audit data is empty");
        }

        return auditData;
    }
}

class AuditData {
    private Long id;
    private Long managerId;

    public AuditData(Long id, Long managerId) {
        this.id = id;
        this.managerId = managerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}