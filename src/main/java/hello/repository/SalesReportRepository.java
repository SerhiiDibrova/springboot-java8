package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByOrderId(Long orderId);
    List<SalesReport> findAllByCustomerName(String customerName);

    @Query("SELECT sr FROM SalesReport sr JOIN WarehouseReport wr ON sr.stockLevel = wr.stockLevel WHERE wr.stockLevel < :threshold")
    List<SalesReport> findSalesReportsWithLowStockLevel(int threshold);

    @Query(value = "INSERT INTO SalesReport (field1, field2, ...) SELECT field1, field2, ... FROM SourceTable WHERE condition", nativeQuery = true)
    void populateSalesReportTable();
}