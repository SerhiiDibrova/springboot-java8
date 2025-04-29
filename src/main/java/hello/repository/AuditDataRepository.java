package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.AuditData;
import java.util.Optional;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    Optional<AuditData> findById(Long id);
    void deleteById(Long id);
}