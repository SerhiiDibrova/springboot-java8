package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    List<AuditData> findAll();
    Optional<AuditData> findById(Long id);
    void deleteById(Long id);
    List<AuditData> findByManagerId(Integer managerId);
    
    @Query("SELECT a FROM AuditData a WHERE a.managerId = ?1 AND a.type = 'SALES'")
    List<AuditData> findByManagerIdAndType(Integer managerId);
}