package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByCustomerId(Long customerId);
    List<SalesReport> findByDateBetween(LocalDate startDate, LocalDate endDate);
}