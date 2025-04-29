package hello.service;

import hello.dto.AuditDataDTO;
import hello.repository.AuditRepository;
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
    private AuditRepository auditRepository;

    @Transactional
    public List<AuditDataDTO> getAuditDataByManagerId(Integer managerId) {
        List<AuditDataDTO> auditDataList = new ArrayList<>();
        String createTempTableSQL = "CREATE TEMPORARY TABLE audit_data (id INT, data VARCHAR(255))";
        String insertDataSQL = "INSERT INTO audit_data (id, data) SELECT id, data FROM audit WHERE manager_id = ? AND type = 'SALES'";
        String selectDataSQL = "SELECT id, data FROM audit_data";
        
        Connection connection = null;
        try {
            connection = auditRepository.getConnection();
            try (PreparedStatement createTableStmt = connection.prepareStatement(createTempTableSQL);
                 PreparedStatement insertDataStmt = connection.prepareStatement(insertDataSQL);
                 PreparedStatement selectDataStmt = connection.prepareStatement(selectDataSQL)) {

                createTableStmt.execute();
                insertDataStmt.setInt(1, managerId);
                insertDataStmt.execute();

                ResultSet resultSet = selectDataStmt.executeQuery();
                while (resultSet.next()) {
                    AuditDataDTO auditData = new AuditDataDTO();
                    auditData.setId(resultSet.getInt("id"));
                    auditData.setData(resultSet.getString("data"));
                    auditDataList.add(auditData);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while processing audit data: " + e.getMessage(), e);
        } finally {
            cleanupTemporaryTable(connection);
        }
        return auditDataList;
    }

    private void cleanupTemporaryTable(Connection connection) {
        String dropTempTableSQL = "DROP TABLE IF EXISTS audit_data";
        if (connection != null) {
            try (PreparedStatement dropTableStmt = connection.prepareStatement(dropTempTableSQL)) {
                dropTableStmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException("Error while cleaning up temporary table: " + e.getMessage(), e);
            }
        }
    }
}