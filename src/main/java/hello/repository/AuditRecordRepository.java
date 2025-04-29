package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import hello.entity.AuditRecord;

import java.util.List;

@Repository
public interface AuditRecordRepository extends JpaRepository<AuditRecord, Long> {
    
    List<AuditRecord> findByUserId(Long userId);
    
    @Query("SELECT ar FROM AuditRecord ar WHERE ar.timestamp BETWEEN :startDate AND :endDate")
    List<AuditRecord> findByTimestampBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
    void deleteByUserId(Long userId);
}