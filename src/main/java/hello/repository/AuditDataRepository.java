package hello.repository;

import hello.entity.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Integer> {

    @Query("SELECT a FROM AuditData a JOIN a.auditRecord ar WHERE a.managerId = :managerId AND a.type = :type")
    List<AuditData> findByManagerIdAndType(@Param("managerId") Long managerId, @Param("type") String type);
}