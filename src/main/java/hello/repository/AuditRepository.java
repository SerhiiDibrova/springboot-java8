package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AuditRepository extends JpaRepository<Audit, Long> {
    
    @Query("SELECT a FROM Audit a JOIN a.auditRecords ar WHERE a.managerId = :managerId")
    List<Audit> findAuditDataByManagerId(@Param("managerId") Long managerId);
}