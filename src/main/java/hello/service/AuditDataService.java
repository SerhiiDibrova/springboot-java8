package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuditDataService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AuditDataRepository auditDataRepository;

    private static final Logger logger = LoggerFactory.getLogger(AuditDataService.class);

    public void setupAuditDataTable() {
        try {
            entityManager.createNativeQuery("CREATE TABLE #audit_data (id INT, manager_id INT, audit_type VARCHAR(255), timestamp DATETIME)").executeUpdate();
        } catch (Exception e) {
            logger.error("Error setting up audit data table", e);
        }
    }

    @Transactional
    public List<AuditDataDTO> insertAuditData(Integer managerId) {
        List<AuditDataDTO> auditDataList = new ArrayList<>();
        if (managerId == null) {
            logger.error("Manager ID cannot be null");
            return auditDataList;
        }
        try {
            String sql = "INSERT INTO #audit_data (id, manager_id, audit_type, timestamp) " +
                         "SELECT id, manager_id, audit_type, timestamp FROM audit a " +
                         "JOIN audit_record ar ON a.id = ar.audit_id " +
                         "WHERE a.manager_id = :managerId AND a.audit_type = 'SALES'";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("managerId", managerId);
            query.executeUpdate();
            auditDataList = executeSelectAuditData();
        } catch (Exception e) {
            logger.error("Error inserting audit data", e);
        }
        return auditDataList;
    }

    public List<AuditData> executeSelectAuditData() {
        return entityManager.createNativeQuery("SELECT * FROM #audit_data", AuditData.class).getResultList();
    }

    public void handleQueryResults(List<AuditData> results) {
        if (!results.isEmpty()) {
            for (AuditData auditData : results) {
                // Process each auditData object as needed
            }
        }
    }

    public void cleanupAuditDataTable() {
        try {
            entityManager.createNativeQuery("DROP TABLE #audit_data").executeUpdate();
        } catch (Exception e) {
            logger.error("Error cleaning up audit data table", e);
        }
    }
}