package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.WarehouseReport;
import java.util.List;

public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    List<WarehouseReport> findByStatus(String status);
    List<WarehouseReport> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);
}