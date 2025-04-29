package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.AuditData;
import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    List<AuditData> findByUserId(Long userId);
    List<AuditData> findByAction(String action);
    List<AuditData> findByTimestampBetween(Long startTime, Long endTime);
}