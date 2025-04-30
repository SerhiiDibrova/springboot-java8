package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.WarehouseReport;

public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
}