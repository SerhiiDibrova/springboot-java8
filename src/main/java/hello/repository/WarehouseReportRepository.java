package hello.repository;

import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    List<WarehouseReport> findAll();
    List<WarehouseReport> findByStockLevel(int stockLevel);
}

@Repository
@Transactional
public class WarehouseReportRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(WarehouseReport warehouseReport) {
        entityManager.persist(warehouseReport);
    }

    public void populateWarehouseReport() {
        Query query = entityManager.createNativeQuery("CREATE TEMPORARY TABLE #WarehouseReport (" +
                "WarehouseId BIGINT, " +
                "WarehouseName VARCHAR(255), " +
                "WarehouseCapacity INT, " +
                "OrderId INT, " +
                "RegionName VARCHAR(255), " +
                "BranchName VARCHAR(255), " +
                "VendorName VARCHAR(255), " +
                "ProductCategory VARCHAR(255), " +
                "StockLevel INT, " +
                "LogisticsEfficiency INT);");
        query.executeUpdate();

        query = entityManager.createNativeQuery("INSERT INTO #WarehouseReport " +
                "SELECT w.WarehouseId, w.WarehouseName, w.WarehouseCapacity, o.OrderId, r.RegionName, " +
                "b.BranchName, v.VendorName, p.ProductCategory, i.StockLevel, l.LogisticsEfficiency " +
                "FROM #TempItems t " +
                "JOIN Orders o ON o.OrderId = t.OrderId " +
                "JOIN Inventory i ON i.OrderId = o.OrderId " +
                "JOIN Warehouses w ON w.WarehouseId = i.WarehouseId " +
                "JOIN Products p ON p.ProductId = i.ProductId " +
                "JOIN Vendors v ON v.VendorId = p.VendorId " +
                "JOIN Branches b ON b.BranchId = o.BranchId " +
                "JOIN Regions r ON r.RegionId = b.RegionId " +
                "JOIN Logistics l ON l.WarehouseId = w.WarehouseId " +
                "JOIN Employees e ON e.BranchId = b.BranchId " +
                "JOIN Financials f ON f.BranchId = b.BranchId " +
                "WHERE (t.OrderId IS NULL OR o.OrderId = t.OrderId) " +
                "AND (t.RegionName IS NULL OR r.RegionName = t.RegionName) " +
                "AND (t.ProductCategory IS NULL OR p.ProductCategory = t.ProductCategory) " +
                "AND (t.StockLevel IS NULL OR i.StockLevel >= t.StockLevel) " +
                "AND (t.LogisticsEfficiency IS NULL OR l.LogisticsEfficiency >= t.LogisticsEfficiency);");
        query.executeUpdate();
    }
}