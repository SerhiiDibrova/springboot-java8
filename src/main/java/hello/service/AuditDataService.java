package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AuditDataService {

    private final AuditDataRepository auditDataRepository;
    private static final Logger logger = Logger.getLogger(AuditDataService.class.getName());

    @Autowired
    public AuditDataService(AuditDataRepository auditDataRepository) {
        this.auditDataRepository = auditDataRepository;
        createTemporaryTable();
    }

    private void createTemporaryTable() {
        String createQuery = "CREATE TABLE #audit_data (audit_id BIGINT, record_details TEXT, created_at TIMESTAMP)";
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createQuery)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            handleErrors(e);
        }
    }

    public List<AuditData> insertAuditData(Long managerId) {
        if (managerId == null) {
            throw new IllegalArgumentException("Manager ID cannot be null");
        }
        List<AuditData> auditDataList = new ArrayList<>();
        String insertQuery = "INSERT INTO #audit_data (audit_id, record_details, created_at) " +
                             "SELECT audit.id, audit_record.details, audit.created_at " +
                             "FROM audit " +
                             "JOIN audit_record ON audit.id = audit_record.audit_id " +
                             "WHERE audit.manager_id = ? AND audit.type = 'SALES'";
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setLong(1, managerId);
            preparedStatement.executeUpdate();
            auditDataList = executeSelectAuditData();
        } catch (SQLException e) {
            handleErrors(e);
        }
        return auditDataList;
    }

    public List<AuditData> executeSelectAuditData() {
        List<AuditData> auditDataList = new ArrayList<>();
        String selectQuery = "SELECT audit_id, record_details, created_at FROM #audit_data";
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                AuditData auditData = new AuditData();
                auditData.setAuditId(resultSet.getLong("audit_id"));
                auditData.setRecordDetails(resultSet.getString("record_details"));
                auditData.setCreatedAt(resultSet.getTimestamp("created_at"));
                auditDataList.add(auditData);
            }
        } catch (SQLException e) {
            handleErrors(e);
        }
        return auditDataList;
    }

    public void cleanupAuditDataTable() {
        String dropQuery = "DROP TABLE IF EXISTS #audit_data";
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(dropQuery)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            handleErrors(e);
        }
    }

    private void handleErrors(SQLException e) {
        logger.log(Level.SEVERE, "SQL Error: " + e.getMessage(), e);
    }

    public void documentAuditData() {
        String documentation = "The #audit_data table is used to store temporary audit records for sales. " +
                               "The SELECT statement retrieves records based on the manager ID and type 'SALES'.";
        logger.info(documentation);
    }
}