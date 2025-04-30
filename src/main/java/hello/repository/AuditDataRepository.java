package hello.repository;

import hello.entity.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditDataRepository extends JpaRepository<AuditData, Integer> {
    List<AuditData> findByManagerIdAndTypeAndType(Long managerId, String type);
    List<AuditData> findAll();
}