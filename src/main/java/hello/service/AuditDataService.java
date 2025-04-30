package hello.service;

import hello.repository.AuditDataRepository;
import hello.model.AuditData;
import hello.service.ErrorHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class AuditDataService {

    private final AuditDataRepository auditDataRepository;
    private final ErrorHandlingService errorHandlingService;
    private final DataSource dataSource;

    @Autowired
    public AuditDataService(AuditDataRepository auditDataRepository, ErrorHandlingService errorHandlingService, DataSource dataSource) {
        this.auditDataRepository = auditDataRepository;
        this.errorHandlingService = errorHandlingService;
        this.dataSource = dataSource;
    }

    @Transactional
    public void setupAuditDataTable() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("IF OBJECT_ID('tempdb..#audit_data') IS NOT NULL DROP TABLE #audit_data; CREATE TABLE #audit_data (id INT, managerId LONG, type VARCHAR(50), details VARCHAR(255))")) {
            statement.execute();
        } catch (SQLException e) {
            errorHandlingService.logError(e);
        }
    }

    @Transactional
    public void insertAuditData(Long managerId) {
        if (managerId == null) {
            throw new IllegalArgumentException("managerId cannot be null");
        }
        List<AuditData> auditDataList = auditDataRepository.findByManagerIdAndType(managerId, "SALES");
        if (auditDataList.isEmpty()) {
            errorHandlingService.logError(new Exception("No records found for managerId: " + managerId));
            return;
        }
        try (Connection connection = dataSource.getConnection()) {
            for (AuditData auditData : auditDataList) {
                try (PreparedStatement statement = connection.prepareStatement("INSERT INTO #audit_data (id, managerId, type, details) VALUES (?, ?, ?, ?)")) {
                    statement.setInt(1, auditData.getId());
                    statement.setLong(2, auditData.getManagerId());
                    statement.setString(3, auditData.getType());
                    statement.setString(4, auditData.getDetails());
                    statement.executeUpdate();
                } catch (SQLException e) {
                    errorHandlingService.logError(e);
                }
            }
        } catch (SQLException e) {
            errorHandlingService.logError(e);
        }
    }

    @Transactional(readOnly = true)
    public void executeSelectAuditData() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM #audit_data");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Process each record as needed
                int id = resultSet.getInt("id");
                long managerId = resultSet.getLong("managerId");
                String type = resultSet.getString("type");
                String details = resultSet.getString("details");
                // Add processing logic here
            }
        } catch (SQLException e) {
            errorHandlingService.logError(e);
        }
    }

    @Transactional
    public void cleanupAuditDataTable() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("IF OBJECT_ID('tempdb..#audit_data') IS NOT NULL DROP TABLE #audit_data")) {
            statement.execute();
        } catch (SQLException e) {
            errorHandlingService.logError(e);
        }
    }
}