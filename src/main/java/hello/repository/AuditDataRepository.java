package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Long> {

    @Query(value = "SELECT a.id AS audit_id, ar.details AS record_details, ar.created_at " +
                   "FROM audit a " +
                   "JOIN audit_record ar ON a.id = ar.audit_id " +
                   "WHERE a.manager_id = :managerId AND a.type = :type", nativeQuery = true)
    List<AuditData> findByManagerIdAndType(Long managerId, String type);

    List<AuditData> findAll();
}