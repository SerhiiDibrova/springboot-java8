

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<AuditData> performAudit(Long managerId, boolean isAuditNeeded) {
        if (!isAuditNeeded) {
            return List.of();
        }

        Long defaultManagerId = getDefaultManagerId(managerId);
        createTempTable();
        insertDataIntoTempTable(defaultManagerId);
        return getAuditData();
    }

    private Long getDefaultManagerId(Long managerId) {
        if (managerId == null) {
            // implement logic to get default manager ID
            return 1L;
        }
        return managerId;
    }

    private void createTempTable() {
        String query = "CREATE TEMPORARY TABLE temp_audit_data (id INT, data VARCHAR(255))";
        try {
            entityManager.createNativeQuery(query).executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create temporary table", e);
        }
    }

    private void insertDataIntoTempTable(Long managerId) {
        String query = "INSERT INTO temp_audit_data (id, data) VALUES (:id, :data)";
        try {
            entityManager.createNativeQuery(query)
                    .setParameter("id", managerId)
                    .setParameter("data", "some data")
                    .executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert data into temporary table", e);
        }
    }

    private List<AuditData> getAuditData() {
        String query = "SELECT * FROM temp_audit_data";
        try {
            return entityManager.createNativeQuery(query, AuditData.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve audit data", e);
        }
    }
}

class AuditData {
    private Long id;
    private String data;

    public AuditData() {}

    public AuditData(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }
}