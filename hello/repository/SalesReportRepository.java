package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    
    List<SalesReport> findByProductId(Long productId);
    
    List<SalesReport> findByCustomerId(Long customerId);
    
    List<SalesReport> findByOrderId(Integer orderId);
    
    List<SalesReport> findAllByManagerId(Integer managerId);
    
    List<SalesReport> findAllByStatus(String status);
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.product.active = true AND sr.customer.active = true")
    List<SalesReport> findActiveSalesReports();
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.product.active = true")
    List<SalesReport> findByActiveProducts();
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.customer.active = true")
    List<SalesReport> findByActiveCustomers();
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.discount.valid = true")
    List<SalesReport> findByValidDiscounts();
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.shipmentStatus = :status")
    List<SalesReport> findByShipmentStatus(String status);
    
    @Query("SELECT sr FROM SalesReport sr WHERE sr.branch.id = :branchId")
    List<SalesReport> findByOperationalBranch(Long branchId);
}