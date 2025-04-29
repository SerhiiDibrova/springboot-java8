package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AuditDataRepository extends JpaRepository<AuditData, Long> {

    @Query("SELECT a FROM AuditData a WHERE a.managerId = :managerId AND a.type = 'SALES'")
    List<AuditData> findSalesAuditDataByManagerId(@Param("managerId") Long managerId);

    @Query(value = "SELECT * FROM audit_data", nativeQuery = true)
    List<AuditData> findAllAuditData();
}