package hello.repository;

import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    List<WarehouseReport> findByWarehouseId(Long warehouseId);
    
    @Query("SELECT r FROM WarehouseReport r WHERE r.someField = ?1")
    List<WarehouseReport> findBySomeField(String someField);
}