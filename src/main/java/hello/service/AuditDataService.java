package hello.service;

import hello.repository.AuditDataRepository;
import hello.dto.AuditDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditDataService {

    private final AuditDataRepository auditDataRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuditDataService(AuditDataRepository auditDataRepository, JdbcTemplate jdbcTemplate) {
        this.auditDataRepository = auditDataRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertAuditData(Integer managerId) {
        List<AuditDataDTO> auditDataList = auditDataRepository.fetchAuditRecordsByManagerId(managerId);
        setupAuditDataTable();
        try {
            for (AuditDataDTO auditData : auditDataList) {
                String sql = "INSERT INTO #audit_data (column1, column2) VALUES (?, ?)";
                jdbcTemplate.update(sql, auditData.getColumn1(), auditData.getColumn2());
            }
        } catch (Exception e) {
            // Handle error (e.g., log the error, throw a custom exception)
        } finally {
            cleanupAuditDataTable();
        }
    }

    private void setupAuditDataTable() {
        String sql = "CREATE TABLE #audit_data (column1 VARCHAR(255), column2 INT)";
        jdbcTemplate.execute(sql);
    }

    public List<AuditDataDTO> retrieveAuditData() {
        String sql = "SELECT * FROM #audit_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new AuditDataDTO(rs.getString("column1"), rs.getInt("column2")));
    }

    private void cleanupAuditDataTable() {
        String sql = "DROP TABLE #audit_data";
        jdbcTemplate.execute(sql);
    }
}