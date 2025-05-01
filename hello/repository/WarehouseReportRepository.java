package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import hello.entity.WarehouseReport;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Integer> {
    List<WarehouseReport> findByStockLevel(int stockLevel);

    @Query("SELECT wr FROM WarehouseReport wr WHERE wr.stockLevel = :stockLevel")
    List<WarehouseReport> findReportsByStockLevel(@Param("stockLevel") int stockLevel);
}