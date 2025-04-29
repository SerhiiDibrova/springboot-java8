package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.WarehouseReport;
import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    Optional<WarehouseReport> findById(Long id);
    List<WarehouseReport> findAll();
    WarehouseReport save(WarehouseReport warehouseReport);
    void deleteById(Long id);
    List<WarehouseReport> findByWarehouseId(Long warehouseId);
}