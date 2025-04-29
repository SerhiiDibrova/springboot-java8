package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    List<AuditData> findByAuditId(Long auditId);
    List<AuditData> findAllByTimestamp(Timestamp timestamp);
    List<AuditData> findByManagerIdAndType(Long managerId, String type);
}