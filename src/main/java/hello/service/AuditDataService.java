package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.repository.AuditDataRepository;
import hello.dto.AuditDataDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuditDataService {

    private final AuditDataRepository auditDataRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuditDataService.class);

    public AuditDataService(AuditDataRepository auditDataRepository) {
        this.auditDataRepository = auditDataRepository;
    }

    @Transactional
    public void setupAuditDataTable() {
        String sql = "CREATE TABLE #audit_data (audit_id INT, record_details VARCHAR(255), created_at TIMESTAMP)";
        executeUpdate(sql);
    }

    @Transactional
    public List<AuditDataDTO> insertAuditData(Integer managerId) {
        List<AuditDataDTO> auditDataList = new ArrayList<>();
        String sql = "INSERT INTO #audit_data (audit_id, record_details, created_at) " +
                     "SELECT a.audit_id, ar.record_details, a.created_at " +
                     "FROM audit a JOIN audit_record ar ON a.audit_id = ar.audit_id " +
                     "WHERE a.manager_id = ? AND a.type = 'SALES'";
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, managerId);
            preparedStatement.executeUpdate();
            auditDataList = executeSelectAuditData();
        } catch (SQLException e) {
            handleErrors(e);
        }
        return auditDataList;
    }

    @Transactional(readOnly = true)
    public List<AuditDataDTO> executeSelectAuditData() {
        List<AuditDataDTO> results = new ArrayList<>();
        String sql = "SELECT audit_id, record_details, created_at FROM #audit_data";
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                AuditDataDTO auditData = new AuditDataDTO();
                auditData.setAuditId(resultSet.getInt("audit_id"));
                auditData.setRecordDetails(resultSet.getString("record_details"));
                auditData.setCreatedAt(resultSet.getTimestamp("created_at"));
                results.add(auditData);
            }
            handleQueryResults(results);
        } catch (SQLException e) {
            handleErrors(e);
        }
        return results;
    }

    public void handleQueryResults(List<AuditDataDTO> results) {
        if (!results.isEmpty()) {
            // Process results as needed
            results.forEach(result -> logger.info("Audit Data: {}", result));
        }
    }

    @Transactional
    public void cleanupAuditDataTable() {
        String sql = "DROP TABLE #audit_data";
        executeUpdate(sql);
    }

    public void handleErrors(Exception exception) {
        logger.error("An error occurred: {}", exception.getMessage());
    }

    public void documentAuditData() {
        String documentation = "The #audit_data table is used to store temporary audit records. " +
                              "It includes fields for audit_id, record_details, and created_at. " +
                              "This table is populated by joining the audit and audit_record tables " +
                              "where the manager_id matches the provided parameter and the type is 'SALES'.";
        logger.info(documentation);
    }

    private void executeUpdate(String sql) {
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            handleErrors(e);
        }
    }
}