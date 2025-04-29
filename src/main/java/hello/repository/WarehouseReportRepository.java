package hello.repository;

import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    
    List<WarehouseReport> findByOrderId(Long orderId);
    
    List<WarehouseReport> findByRegionName(String regionName);
    
    List<WarehouseReport> findAllByStockLevelGreaterThanEqual(Integer stockLevel);
    
    @Transactional
    @Query(value = "INSERT INTO WarehouseReport (WarehouseId, WarehouseName, WarehouseCapacity, OrderId, RegionName, BranchName, VendorName, ProductCategory, StockLevel, LogisticsEfficiency) " +
                   "SELECT w.id, w.name, w.capacity, o.id, r.name, b.name, v.name, p.category, i.stock_level, l.efficiency " +
                   "FROM Warehouses w " +
                   "INNER JOIN Orders o ON w.id = o.warehouse_id " +
                   "INNER JOIN Inventory i ON o.product_id = i.product_id " +
                   "INNER JOIN Products p ON i.product_id = p.id " +
                   "INNER JOIN Vendors v ON p.vendor_id = v.id " +
                   "INNER JOIN Branches b ON w.branch_id = b.id " +
                   "INNER JOIN Regions r ON b.region_id = r.id " +
                   "INNER JOIN Legacy_Logistics l ON w.id = l.warehouse_id " +
                   "INNER JOIN Legacy_Financials f ON o.id = f.order_id " +
                   "WHERE (:orderId IS NULL OR o.id = :orderId) " +
                   "AND (:regionName IS NULL OR r.name = :regionName) " +
                   "AND (:productCategory IS NULL OR p.category = :productCategory) " +
                   "AND (:stockLevel IS NULL OR i.stock_level >= :stockLevel) " +
                   "AND (:logisticsEfficiency IS NULL OR l.efficiency = :logisticsEfficiency)", 
           nativeQuery = true)
    boolean populateWarehouseReport(@Param("orderId") Long orderId, 
                                    @Param("regionName") String regionName, 
                                    @Param("productCategory") String productCategory, 
                                    @Param("stockLevel") Integer stockLevel, 
                                    @Param("logisticsEfficiency") String logisticsEfficiency);
}