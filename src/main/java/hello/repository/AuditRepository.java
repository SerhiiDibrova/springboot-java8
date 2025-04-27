package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AuditRepository extends JpaRepository<Audit, Integer> {
    
    @Query("SELECT new hello.dto.AuditDataDTO(a) FROM Audit a WHERE a.managerId = ?1 AND a.type = ?2")
    List<AuditDataDTO> findAuditDataByManagerIdAndType(Integer managerId, String type);
}