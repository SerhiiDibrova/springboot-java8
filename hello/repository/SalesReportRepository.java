package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {

    List<SalesReport> findBySalesAmountGreaterThan(Double amount);

    List<SalesReport> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Transactional
    SalesReport save(SalesReport salesReport);

    @Transactional
    void deleteById(Long id);

    @Transactional
    SalesReport findById(Long id);

    List<SalesReport> findBySalesAmountBetween(Double minAmount, Double maxAmount);

    List<SalesReport> findByStatus(String status);
}