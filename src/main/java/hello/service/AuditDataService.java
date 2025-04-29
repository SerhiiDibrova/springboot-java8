package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class AuditDataService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Autowired
    private AuditRecordRepository auditRecordRepository;

    @Transactional
    public void insertAuditData(Integer managerId) {
        String createTableQuery = "CREATE TABLE #audit_data AS SELECT * FROM audit WHERE manager_id = :managerId AND category = 'SALES'";
        String dropTableQuery = "DROP TABLE #audit_data";

        try {
            entityManager.createNativeQuery(createTableQuery)
                    .setParameter("managerId", managerId)
                    .executeUpdate();

            entityManager.createNativeQuery(dropTableQuery).executeUpdate();
        } catch (Exception e) {
            throw new DataAccessException("Error while inserting audit data", e);
        }
    }
}