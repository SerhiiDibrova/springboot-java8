package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByCustomerId(Long customerId);
    List<SalesReport> findByDateBetween(Date startDate, Date endDate);
    
    @Query("SELECT CASE WHEN s.salesAmount > 1000 THEN 'High' ELSE 'Low' END FROM SalesReport s")
    List<String> findSalesStatus();

    @Query("SELECT s FROM SalesReport s JOIN s.customer c WHERE c.id = :customerId")
    List<SalesReport> findSalesReportsByCustomerId(Long customerId);
}