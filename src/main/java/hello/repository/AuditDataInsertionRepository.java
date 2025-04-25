package hello.repository;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class AuditDataInsertionRepositoryImpl implements AuditDataInsertionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AuditDataModel> findAllAuditData() {
        String sql = "SELECT * FROM #audit_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AuditDataModel auditData = new AuditDataModel();
            // Assuming AuditDataModel has appropriate setters
            auditData.setId(rs.getLong("id"));
            auditData.setAction(rs.getString("action"));
            auditData.setTimestamp(rs.getTimestamp("timestamp"));
            return auditData;
        });
    }
}