package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.AuditData;
import java.util.List;

public interface AuditDataRepository extends JpaRepository<AuditData, Integer> {
    void insert(AuditData auditData);
    List<AuditData> findByCriteria(String criteria);
}