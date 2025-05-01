package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class WarehouseReportRepositoryImpl implements WarehouseReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWarehouseReportData() {
        String sql = "CREATE TABLE #WarehouseReport (WarehouseId INT, WarehouseName VARCHAR(255), WarehouseCapacity INT, OrderId INT, RegionName VARCHAR(255), BranchName VARCHAR(255), VendorName VARCHAR(255), ProductCategory VARCHAR(255), StockLevel INT, LogisticsEfficiency INT); " +
                     "INSERT INTO #WarehouseReport (WarehouseId, WarehouseName, WarehouseCapacity, OrderId, RegionName, BranchName, VendorName, ProductCategory, StockLevel, LogisticsEfficiency) " +
                     "SELECT w.WarehouseId, w.WarehouseName, w.WarehouseCapacity, o.OrderId, r.RegionName, b.BranchName, v.VendorName, p.ProductCategory, i.StockLevel, l.LogisticsEfficiency " +
                     "FROM #TempItems AS t " +
                     "JOIN Orders AS o ON o.OrderId = t.OrderId " +
                     "JOIN Inventory AS i ON i.OrderId = o.OrderId " +
                     "JOIN Warehouses AS w ON w.WarehouseId = i.WarehouseId " +
                     "JOIN Products AS p ON p.ProductId = i.ProductId " +
                     "JOIN Vendors AS v ON v.VendorId = p.VendorId " +
                     "JOIN Branches AS b ON b.BranchId = o.BranchId " +
                     "JOIN Regions AS r ON r.RegionId = b.RegionId " +
                     "JOIN Logistics AS l ON l.WarehouseId = w.WarehouseId " +
                     "JOIN Employees AS e ON e.BranchId = b.BranchId " +
                     "JOIN Financials AS f ON f.BranchId = b.BranchId " +
                     "WHERE (t.OrderId IS NULL OR o.OrderId = t.OrderId) " +
                     "AND (t.RegionName IS NULL OR r.RegionName = t.RegionName) " +
                     "AND (t.ProductCategory IS NULL OR p.ProductCategory = t.ProductCategory) " +
                     "AND (t.StockLevel IS NULL OR i.StockLevel >= t.StockLevel) " +
                     "AND (t.LogisticsEfficiency IS NULL OR l.LogisticsEfficiency >= t.LogisticsEfficiency)";
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }
}