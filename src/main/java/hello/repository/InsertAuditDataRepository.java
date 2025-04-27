package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface InsertAuditDataRepository extends JpaRepository<AuditDataDTO, Long> {

    @Query("SELECT new hello.dto.AuditDataDTO(a.id, a.recordId, a.timestamp, a.type) " +
           "FROM Audit a JOIN AuditRecord ar ON a.id = ar.auditId " +
           "WHERE ar.managerId = :managerId AND a.type = 'SALES'")
    List<AuditDataDTO> fetchAuditData(@Param("managerId") int managerId);
}