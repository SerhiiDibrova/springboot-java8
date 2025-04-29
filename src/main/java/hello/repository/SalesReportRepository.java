package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.status = :status")
    List<SalesReport> findByStatus(@Param("status") String status);
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.date BETWEEN :startDate AND :endDate")
    List<SalesReport> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
}