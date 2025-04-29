package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.WarehouseReport;
import java.util.List;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    List<WarehouseReport> findByStatus(String status);
    List<WarehouseReport> findByWarehouseId(Long warehouseId);
    List<WarehouseReport> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);
}