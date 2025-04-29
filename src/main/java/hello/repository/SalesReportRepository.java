package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByOrderId(Integer orderId);
    List<SalesReport> findAllByManagerId(Integer managerId);
    SalesReport findById(Long id);
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.salesAmount >= 1000")
    List<SalesReport> findReportsWithMinimumSalesAmount();
}