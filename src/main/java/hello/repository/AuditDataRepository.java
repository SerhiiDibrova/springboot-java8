package hello.repository;

import hello.entity.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {

    @Query(value = "SELECT * FROM audit_data", nativeQuery = true)
    List<AuditData> findAllAuditData();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO audit_data (auditId, recordDetails, timestamp) VALUES (:auditId, :recordDetails, :timestamp)", nativeQuery = true)
    void insertAuditData(@Param("auditId") String auditId, 
                         @Param("recordDetails") String recordDetails, 
                         @Param("timestamp") LocalDateTime timestamp);

    @Query("SELECT new hello.entity.AuditData(a.id, ar.details, ar.createdAt) " +
           "FROM Audit a JOIN AuditRecord ar ON a.id = ar.auditId " +
           "WHERE a.managerId = :managerId AND a.type = 'SALES'")
    List<AuditData> findByManagerIdAndType(@Param("managerId") Integer managerId);
}