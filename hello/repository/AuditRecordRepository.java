package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.AuditRecord;
import org.springframework.dao.DataAccessException;
import java.util.List;

@Repository
public interface AuditRecordRepository extends JpaRepository<AuditRecord, Integer> {
    List<AuditRecord> findByAuditId(int auditId) throws DataAccessException;
}