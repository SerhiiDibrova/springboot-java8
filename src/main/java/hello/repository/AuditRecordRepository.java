package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.AuditRecord;
import java.util.List;

public interface AuditRecordRepository extends JpaRepository<AuditRecord, Long> {
    List<AuditRecord> findByAuditId(Long auditId);
}