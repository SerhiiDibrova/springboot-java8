package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    void insertAuditData(AuditData auditData);
    List<AuditData> findByManagerId(Integer managerId);
}