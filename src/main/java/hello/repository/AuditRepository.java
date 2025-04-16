

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.model.AuditData;

@Repository
public interface AuditRepository extends JpaRepository<AuditData, Long> {

    List<AuditData> findByManagerId(Long managerId);

}