package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.WarehouseReport;
import java.util.List;

public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    void insertWarehouseReport(List<WarehouseReport> reports);
}