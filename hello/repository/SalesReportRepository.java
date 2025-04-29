package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    
    List<SalesReport> findByActiveProduct(boolean active);

    @Query("SELECT sr FROM SalesReport sr WHERE sr.discount IS NOT NULL AND sr.discount > 0")
    List<SalesReport> findValidDiscounts();

    void deleteById(Long id);
}