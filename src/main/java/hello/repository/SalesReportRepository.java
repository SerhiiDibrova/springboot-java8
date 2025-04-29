package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.entity.SalesReport;

import java.util.List;

public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.date BETWEEN :startDate AND :endDate")
    List<SalesReport> findSalesReportsBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
    @Query("SELECT SUM(sr.amount) FROM SalesReport sr WHERE sr.date = :date")
    Double getTotalSalesByDate(@Param("date") String date);
    
    void insertSalesReport(SalesReport salesReport);
}