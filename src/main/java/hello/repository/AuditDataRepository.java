package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.AuditData;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    List<AuditData> findByManagerIdAndType(Long managerId, String type);
    
    <S extends AuditData> S save(S entity);
}