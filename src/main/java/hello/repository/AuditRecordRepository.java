package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditRecordRepository extends JpaRepository<AuditRecord, Long> {
    List<AuditRecord> findByAuditId(Long auditId);
}