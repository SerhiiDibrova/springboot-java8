package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import hello.model.AuditData;
import hello.repository.InsertAuditDataRepository;

@Service
public class InsertAuditDataService {

    @Autowired
    private InsertAuditDataRepository insertAuditDataRepository;

    public List<AuditData> getAuditData(int managerId) {
        String sql = "SELECT a.id, a.manager_id, ar.id AS record_id, ar.timestamp FROM audit a JOIN audit_record ar ON a.id = ar.audit_id WHERE a.manager_id = ?";
        return insertAuditDataRepository.query(sql, new Object[]{managerId}, (rs, rowNum) -> {
            AuditData auditData = new AuditData();
            auditData.setId(rs.getInt("id"));
            auditData.setManagerId(rs.getInt("manager_id"));
            auditData.setRecordId(rs.getInt("record_id"));
            auditData.setTimestamp(rs.getTimestamp("timestamp"));
            return auditData;
        });
    }
}