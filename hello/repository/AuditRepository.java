package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import hello.entity.Audit;

@Transactional(readOnly = true)
public interface AuditRepository extends JpaRepository<Audit, Integer> {
    
    @Query("SELECT a FROM Audit a WHERE a.managerId = :managerId AND a.type = 'SALES'")
    List<Audit> findByManagerIdAndType(@Param("managerId") int managerId);
}