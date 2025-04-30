package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.AuditData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    
    void insertAuditData(@Param("auditId") Integer auditId, @Param("recordDetails") String recordDetails, @Param("createdAt") LocalDateTime createdAt);
    
    @Query("SELECT a FROM AuditData a WHERE a.managerId = :managerId AND a.type = :type")
    List<AuditData> findByManagerIdAndType(@Param("managerId") Long managerId, @Param("type") String type);
    
    List<AuditData> findAll();
}