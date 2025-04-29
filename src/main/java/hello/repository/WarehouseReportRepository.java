package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    void insertWarehouseReport(WarehouseReport warehouseReport);
    List<WarehouseReport> findByOrderId(Integer orderId);
}