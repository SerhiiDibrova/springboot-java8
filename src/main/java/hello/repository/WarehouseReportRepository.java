package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.entity.WarehouseReport;
import java.util.List;

public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    
    List<WarehouseReport> findByStatus(String status);
    
    @Query("SELECT wr FROM WarehouseReport wr WHERE wr.createdDate >= :startDate AND wr.createdDate <= :endDate")
    List<WarehouseReport> findReportsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    
    @Query("SELECT wr FROM WarehouseReport wr WHERE wr.warehouseId = :warehouseId")
    List<WarehouseReport> findByWarehouseId(@Param("warehouseId") Long warehouseId);
}