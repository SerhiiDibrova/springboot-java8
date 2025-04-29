package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.SalesReport;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByCustomerId(Long customerId);
    List<SalesReport> findByDateBetween(String startDate, String endDate);
    List<SalesReport> findByProductId(Long productId);
}