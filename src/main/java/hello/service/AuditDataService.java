package hello.service;

import hello.dto.AuditData;
import hello.exception.DataInsertionException;
import hello.repository.AuditDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    private static final Logger logger = LoggerFactory.getLogger(AuditDataService.class);

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Transactional
    public void setupAuditDataTable() {
        String sql = "CREATE TEMPORARY TABLE audit_data (audit_id BIGINT, record_details TEXT, created_at TIMESTAMP)";
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("Error setting up audit data table", e);
            throw new DataInsertionException("Failed to setup audit data table", e);
        }
    }

    @Transactional
    public List<AuditData> insertAuditData(Long managerId) {
        String sql = "INSERT INTO audit_data (audit_id, record_details, created_at) " +
                     "SELECT audit.id, audit_record.details, audit.created_at " +
                     "FROM audit " +
                     "JOIN audit_record ON audit.id = audit_record.audit_id " +
                     "WHERE audit.manager_id = ? AND audit.type = 'SALES'";
        List<AuditData> auditDataList = new ArrayList<>();
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, managerId);
            preparedStatement.executeUpdate();
            auditDataList = executeSelectAuditData();
        } catch (SQLException e) {
            logger.error("Error inserting audit data", e);
            throw new DataInsertionException("Failed to insert audit data", e);
        }
        return auditDataList;
    }

    @Transactional(readOnly = true)
    @Cacheable("auditDataCache")
    public List<AuditData> executeSelectAuditData() {
        String sql = "SELECT audit_id, record_details, created_at FROM audit_data";
        List<AuditData> auditDataList = new ArrayList<>();
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                AuditData auditData = new AuditData();
                auditData.setAuditId(resultSet.getLong("audit_id"));
                auditData.setRecordDetails(resultSet.getString("record_details"));
                auditData.setCreatedAt(resultSet.getTimestamp("created_at"));
                auditDataList.add(auditData);
            }
        } catch (SQLException e) {
            logger.error("Error executing select query on audit data", e);
            throw new DataInsertionException("Failed to execute select query on audit data", e);
        }
        return auditDataList;
    }

    @Transactional
    public void cleanupAuditDataTable() {
        String sql = "DROP TABLE IF EXISTS audit_data";
        try (Connection connection = auditDataRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("Error cleaning up audit data table", e);
            throw new DataInsertionException("Failed to cleanup audit data table", e);
        }
    }
}