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

    @Query("SELECT sr FROM SalesReport sr WHERE (:startDate IS NULL OR sr.date >= :startDate) " +
           "AND (:endDate IS NULL OR sr.date <= :endDate) " +
           "AND (:customerId IS NULL OR sr.customerId = :customerId) " +
           "AND (:productId IS NULL OR sr.productId = :productId) " +
           "AND (:customerSegment IS NULL OR sr.customerSegment = :customerSegment) " +
           "AND (:productCategory IS NULL OR sr.productCategory = :productCategory)")
    List<SalesReport> findSalesReports(@Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate,
                                        @Param("customerId") Long customerId,
                                        @Param("productId") Long productId,
                                        @Param("customerSegment") String customerSegment,
                                        @Param("productCategory") String productCategory);

    List<SalesReport> findAll();
}