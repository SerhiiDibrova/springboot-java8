package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditDataService {

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public void setupAuditDataTable() {
        String sql = "CREATE TABLE #audit_data (audit_id INT, record_details VARCHAR(255), created_at TIMESTAMP)";
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public List<AuditDataDTO> insertAuditData(Integer managerId) {
        List<AuditDataDTO> auditDataList = new ArrayList<>();
        String queryStr = "SELECT a.audit_id, ar.record_details, a.created_at " +
                          "FROM audit a JOIN audit_record ar ON a.audit_id = ar.audit_id " +
                          "WHERE a.manager_id = :managerId AND a.type = 'SALES'";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter("managerId", managerId);
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            AuditDataDTO auditData = new AuditDataDTO();
            auditData.setAuditId((Integer) result[0]);
            auditData.setRecordDetails((String) result[1]);
            auditData.setCreatedAt((Timestamp) result[2]);
            auditDataList.add(auditData);
            auditDataRepository.save(auditData);
        }

        String insertSql = "INSERT INTO #audit_data (audit_id, record_details, created_at) " +
                           "SELECT a.audit_id, ar.record_details, a.created_at " +
                           "FROM audit a JOIN audit_record ar ON a.audit_id = ar.audit_id " +
                           "WHERE a.manager_id = :managerId AND a.type = 'SALES'";
        entityManager.createNativeQuery(insertSql).setParameter("managerId", managerId).executeUpdate();

        return auditDataList;
    }

    public List<AuditDataDTO> executeSelectAuditData() {
        String sql = "SELECT * FROM #audit_data";
        Query query = entityManager.createNativeQuery(sql, AuditDataDTO.class);
        return query.getResultList();
    }

    public void handleQueryResults(List<AuditDataDTO> results) {
        if (!results.isEmpty()) {
            // Process results
        }
    }

    public void cleanupAuditDataTable() {
        String sql = "IF OBJECT_ID('tempdb..#audit_data') IS NOT NULL DROP TABLE #audit_data";
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    public void handleErrors(Exception e) {
        // Log error
    }

    public void documentAuditData() {
        // Document purpose and assumptions
    }
}