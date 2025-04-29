package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.AuditData;
import java.util.List;

public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    List<AuditData> findByAuditId(Integer auditId);
}