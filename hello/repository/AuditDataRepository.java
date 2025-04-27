package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.AuditData;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
}