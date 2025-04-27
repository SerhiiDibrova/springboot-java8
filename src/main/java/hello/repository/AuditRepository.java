package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import hello.model.Audit;

public interface AuditRepository extends JpaRepository<Audit, Integer> {
    List<Audit> findByManagerIdAndType(Integer managerId, String type);
}