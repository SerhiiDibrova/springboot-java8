package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.entity.SalesReport;
import java.util.List;

public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.salesDate BETWEEN :startDate AND :endDate")
    List<SalesReport> findSalesReportsBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.productId = :productId")
    List<SalesReport> findSalesReportsByProductId(@Param("productId") Long productId);
    
    @Query("SELECT sr FROM SalesReport sr ORDER BY sr.totalSales DESC")
    List<SalesReport> findTopSalesReports();
}