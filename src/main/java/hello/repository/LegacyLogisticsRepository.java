package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface LegacyLogisticsRepository extends JpaRepository<LegacyLogistics, Long> {
    List<LegacyLogistics> findByWarehouseId(Long warehouseId);
    
    @Query("SELECT l FROM LegacyLogistics l WHERE l.logisticsId = :logisticsId")
    LegacyLogistics findByLogisticsId(@Param("logisticsId") Long logisticsId);
    
    void deleteById(Long id);
    
    @Query("SELECT l FROM LegacyLogistics l WHERE l.status = :status")
    List<LegacyLogistics> findByStatus(@Param("status") String status);
    
    @Query("SELECT l FROM LegacyLogistics l WHERE l.date BETWEEN :startDate AND :endDate")
    List<LegacyLogistics> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}