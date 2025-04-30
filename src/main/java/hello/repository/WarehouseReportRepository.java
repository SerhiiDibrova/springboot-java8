package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
}