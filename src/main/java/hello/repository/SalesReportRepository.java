package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    @Query("SELECT sr FROM SalesReport sr JOIN sr.warehouseReport wr WHERE wr.stockLevel = 0")
    List<SalesReport> findSalesReportsByStockLevelZero();

    List<SalesReport> findByCustomerId(Long customerId);

    List<SalesReport> findByReportDateBetween(Date startDate, Date endDate);

    @Query("SELECT sr FROM SalesReport sr " +
           "JOIN sr.order o " +
           "JOIN o.salesData s " +
           "JOIN s.tempItems t " +
           "JOIN t.products p " +
           "JOIN p.customers c " +
           "JOIN p.discounts d " +
           "JOIN o.shipments sh " +
           "WHERE sr.reportDate BETWEEN :startDate AND :endDate " +
           "AND c.status = 'Active' " +
           "AND p.isActive = 1 " +
           "AND d.isValid = 1 " +
           "AND wr.stockLevel = 0 " +
           "AND (:customerSegment IS NULL OR sr.customerSegment = :customerSegment) " +
           "AND (:productCategory IS NULL OR sr.productCategory = :productCategory)")
    List<SalesReport> findSalesReports(@Param("startDate") Date startDate, 
                                        @Param("endDate") Date endDate, 
                                        @Param("customerSegment") String customerSegment, 
                                        @Param("productCategory") String productCategory);
}