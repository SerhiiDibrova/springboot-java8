package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.SalesReport;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByCustomerId(Long customerId);
    List<SalesReport> findByProductId(Long productId);
    List<SalesReport> findBySalesDateBetween(LocalDate startDate, LocalDate endDate);
}