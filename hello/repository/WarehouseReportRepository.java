package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO warehouse_report (column1, column2, ...) VALUES (:#{#warehouseReports[0].column1}, :#{#warehouseReports[0].column2}, ...), (:#{#warehouseReports[1].column1}, :#{#warehouseReports[1].column2}, ...), ...", nativeQuery = true)
    void insertWarehouseReport(List<WarehouseReport> warehouseReports);
}