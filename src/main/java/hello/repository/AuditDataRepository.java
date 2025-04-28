package hello.repository;

import hello.entity.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    List<AuditData> findByManagerIdAndType(Integer managerId, String type);
    List<Object[]> findAuditDataByManagerId(Integer managerId);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO #audit_data (auditId, recordDetails, timestamp) SELECT a.id, ar.details, ar.created_at FROM audit a JOIN audit_record ar ON a.id = ar.audit_id WHERE a.manager_id = :managerId AND a.type = 'SALES'", nativeQuery = true)
    void insertAuditData(@Param("managerId") Integer managerId);
    
    @Modifying
    @Transactional
    @Query(value = "CREATE TEMPORARY TABLE #audit_data (id INT, auditId INT, recordDetails VARCHAR(255), timestamp DATETIME)", nativeQuery = true)
    void setupAuditDataTable();
    
    @Query(value = "SELECT * FROM #audit_data", nativeQuery = true)
    List<Object[]> executeSelectAuditData();
    
    @Modifying
    @Transactional
    @Query(value = "DROP TABLE #audit_data", nativeQuery = true)
    void cleanupAuditDataTable();
    
    void handleErrors(Exception e);
}