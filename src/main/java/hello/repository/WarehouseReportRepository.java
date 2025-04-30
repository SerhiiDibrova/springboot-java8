package hello.repository;

import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    
    @Query("SELECT wr FROM WarehouseReport wr " +
           "INNER JOIN Orders o ON o.OrderId = wr.OrderId " +
           "INNER JOIN Inventory i ON i.OrderId = o.OrderId " +
           "INNER JOIN Warehouses w ON w.WarehouseId = i.WarehouseId " +
           "INNER JOIN Products p ON p.ProductId = i.ProductId " +
           "INNER JOIN Vendors v ON v.VendorId = p.VendorId " +
           "INNER JOIN Branches b ON b.BranchId = o.BranchId " +
           "INNER JOIN Regions r ON r.RegionId = b.RegionId " +
           "INNER JOIN Logistics l ON l.WarehouseId = w.WarehouseId " +
           "INNER JOIN Employees e ON e.BranchId = b.BranchId " +
           "INNER JOIN Financials f ON f.BranchId = b.BranchId " +
           "WHERE (wr.OrderId IS NULL OR o.OrderId = wr.OrderId) " +
           "AND (wr.RegionName IS NULL OR r.RegionName = wr.RegionName) " +
           "AND (wr.ProductCategory IS NULL OR p.ProductCategory = wr.ProductCategory) " +
           "AND (wr.StockLevel IS NULL OR i.StockLevel >= wr.StockLevel) " +
           "AND (wr.LogisticsEfficiency IS NULL OR l.LogisticsEfficiency >= wr.LogisticsEfficiency)")
    List<WarehouseReport> findFilteredReports();
}