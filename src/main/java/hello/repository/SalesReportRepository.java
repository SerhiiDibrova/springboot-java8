package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.SalesReport;
import java.util.Date;
import java.util.List;

public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByReportDateBetween(Date startDate, Date endDate);
    List<SalesReport> findByCustomerId(Long customerId);
    List<SalesReport> findByOrderId(Integer orderId);
}