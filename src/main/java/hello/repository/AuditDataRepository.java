package hello.repository;

import hello.entity.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    @Query("SELECT a FROM AuditData a JOIN a.auditRecords ar WHERE a.managerId = :managerId AND a.type = :type")
    List<AuditData> findByManagerIdAndType(@Param("managerId") Integer managerId, @Param("type") String type);
}