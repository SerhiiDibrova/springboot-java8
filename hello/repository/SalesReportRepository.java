package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.product.active = true AND sr.discount.valid = true AND sr.branch.operational = true")
    List<SalesReport> findActiveSalesReports();

    @Query("SELECT sr FROM SalesReport sr WHERE sr.id = :id")
    SalesReport findById(@Param("id") Long id);

    void deleteById(Long id);
}