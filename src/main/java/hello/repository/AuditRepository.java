package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.Audit;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
    List<Audit> findByManagerIdAndType(Integer managerId, String type);

    @Transactional(readOnly = true)
    default List<Audit> findSalesAuditsByManagerId(Integer managerId) {
        return findByManagerIdAndType(managerId, "SALES");
    }
}