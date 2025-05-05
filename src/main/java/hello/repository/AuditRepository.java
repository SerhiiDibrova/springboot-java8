package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<AuditDataDTO, Integer> {

    @Query(value = "INSERT INTO #audit_data (audit_id, user_id, action, timestamp, details) VALUES (?, ?, ?, ?, ?)", nativeQuery = true)
    void insertAuditData(int auditId, int userId, String action, LocalDateTime timestamp, String details);

    @Query("SELECT a.id, ar.details, ar.createdAt FROM Audit a JOIN a.auditRecords ar WHERE a.managerId = :managerId AND a.type = :type")
    List<AuditDataDTO> findAuditDataByManagerIdAndType(@Param("managerId") Integer managerId, @Param("type") String type);
}