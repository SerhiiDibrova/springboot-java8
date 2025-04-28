package hello.repository;

import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    
    Logger logger = LoggerFactory.getLogger(WarehouseReportRepository.class);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO WarehouseReport (WarehouseId, WarehouseName, WarehouseCapacity, OrderId, RegionName, BranchName, VendorName, ProductCategory, StockLevel, LogisticsEfficiency) SELECT w.WarehouseId, w.WarehouseName, w.WarehouseCapacity, o.OrderId, r.RegionName, b.BranchName, v.VendorName, p.ProductCategory, i.StockLevel, l.LogisticsEfficiency FROM TempItems t JOIN Orders o ON o.OrderId = t.OrderId JOIN Inventory i ON i.OrderId = o.OrderId JOIN Warehouses w ON w.WarehouseId = i.WarehouseId JOIN Products p ON p.ProductId = i.ProductId JOIN Vendors v ON v.VendorId = p.VendorId JOIN Branches b ON b.BranchId = o.BranchId JOIN Regions r ON r.RegionId = b.RegionId JOIN Logistics l ON l.WarehouseId = w.WarehouseId WHERE (t.OrderId IS NULL OR o.OrderId = t.OrderId) AND (t.RegionName IS NULL OR r.RegionName = t.RegionName) AND (t.ProductCategory IS NULL OR p.ProductCategory = t.ProductCategory) AND (t.StockLevel IS NULL OR i.StockLevel >= t.StockLevel) AND (t.LogisticsEfficiency IS NULL OR l.LogisticsEfficiency >= t.LogisticsEfficiency)", nativeQuery = true)
    void insertWarehouseReport() throws DataAccessException;

    List<WarehouseReport> findByOrderIdAndRegionNameAndProductCategoryAndStockLevelAndLogisticsEfficiency(
        Integer orderId, String regionName, String productCategory, Integer stockLevel, Integer logisticsEfficiency);

    List<WarehouseReport> findByCondition(String condition);

    @Modifying
    @Transactional
    @Query("DELETE FROM WarehouseReport wr WHERE wr.date < :date")
    void deleteOldReports(@Param("date") LocalDate date) throws DataAccessException;
}