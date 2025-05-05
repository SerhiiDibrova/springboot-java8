package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuditRepositoryImpl implements AuditRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void executeCreateTable(String sql) {
        try {
            Query query = entityManager.createNativeQuery(sql);
            query.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error executing create table SQL", e);
        }
    }

    @Override
    @Transactional
    public void executeInsertAuditData(String sql, List<AuditDataDTO> auditRecords) {
        try {
            for (AuditDataDTO record : auditRecords) {
                Query query = entityManager.createNativeQuery(sql);
                query.setParameter(1, record.getAuditId());
                query.setParameter(2, record.getUserId());
                query.setParameter(3, record.getAction());
                query.setParameter(4, record.getTimestamp());
                query.setParameter(5, record.getDetails());
                query.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error executing insert audit data SQL", e);
        }
    }

    @Override
    public List<AuditDataDTO> findAllAuditData() {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM #audit_data", AuditDataDTO.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving audit data", e);
        }
    }
}