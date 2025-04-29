package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.entity.AuditData;
import java.util.List;

public interface AuditDataRepository extends JpaRepository<AuditData, Long> {
    
    List<AuditData> findByUserId(Long userId);
    
    @Query("SELECT a FROM AuditData a WHERE a.timestamp BETWEEN :startDate AND :endDate")
    List<AuditData> findByTimestampBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
    void deleteByUserId(Long userId);
}