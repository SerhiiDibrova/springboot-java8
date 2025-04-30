package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByOrderId(Integer orderId);
    List<SalesReport> findByManagerId(Integer managerId);
    List<SalesReport> findByOrderIdAndManagerId(Integer orderId, Integer managerId);
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.orderId = :orderId AND sr.managerId = :managerId")
    List<SalesReport> findSalesReportByOrderIdAndManagerId(Integer orderId, Integer managerId);
}