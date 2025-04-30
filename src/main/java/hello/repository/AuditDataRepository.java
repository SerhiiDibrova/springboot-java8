package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.AuditData;
import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    List<AuditData> findAll();
    List<AuditData> findByManagerIdAndType(Integer managerId, String type);
}