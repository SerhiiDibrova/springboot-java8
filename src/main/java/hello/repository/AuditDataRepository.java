package hello.repository;

import hello.entity.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    @Query("SELECT new hello.entity.AuditData(a.id, ar.details, ar.createdAt) " +
           "FROM Audit a JOIN AuditRecord ar ON a.id = ar.auditId " +
           "WHERE a.managerId = :managerId AND a.type = 'SALES'")
    List<AuditData> findByManagerIdAndType(@Param("managerId") Integer managerId, @Param("type") String type);

    @Override
    AuditData save(AuditData auditData);

    @Override
    List<AuditData> findAll();
}