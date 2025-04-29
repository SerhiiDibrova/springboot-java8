package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseReportService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WarehouseReportService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void populateWarehouseReport() {
        String createTempTableSql = "CREATE TABLE #WarehouseReport (WarehouseId INT, WarehouseName VARCHAR(255), WarehouseCapacity INT, OrderId INT, RegionName VARCHAR(255), BranchName VARCHAR(255), VendorName VARCHAR(255), ProductCategory VARCHAR(255), StockLevel INT, LogisticsEfficiency DECIMAL(5,2))";
        jdbcTemplate.execute(createTempTableSql);

        String checkTempItemsSql = "SELECT COUNT(*) FROM #TempItems";
        Integer tempItemsCount = jdbcTemplate.queryForObject(checkTempItemsSql, Integer.class);
        if (tempItemsCount == null || tempItemsCount == 0) {
            throw new IllegalStateException("The #TempItems table is not populated.");
        }

        String insertDataSql = "INSERT INTO #WarehouseReport (WarehouseId, WarehouseName, WarehouseCapacity, OrderId, RegionName, BranchName, VendorName, ProductCategory, StockLevel, LogisticsEfficiency) " +
                "SELECT w.WarehouseId, w.WarehouseName, w.WarehouseCapacity, o.OrderId, r.RegionName, b.BranchName, v.VendorName, p.ProductCategory, i.StockLevel, l.LogisticsEfficiency " +
                "FROM #TempItems t " +
                "INNER JOIN Orders o ON t.OrderId = o.OrderId " +
                "INNER JOIN Inventory i ON o.OrderId = i.OrderId " +
                "INNER JOIN Warehouses w ON i.WarehouseId = w.WarehouseId " +
                "INNER JOIN Regions r ON w.RegionId = r.RegionId " +
                "INNER JOIN Branches b ON w.BranchId = b.BranchId " +
                "INNER JOIN Vendors v ON i.VendorId = v.VendorId " +
                "INNER JOIN Products p ON i.ProductId = p.ProductId " +
                "INNER JOIN Legacy_Logistics l ON o.OrderId = l.OrderId " +
                "INNER JOIN Legacy_Financials f ON o.OrderId = f.OrderId " +
                "WHERE t.OrderId IS NOT NULL AND t.OrderId <> ''";

        try {
            jdbcTemplate.execute(insertDataSql);
        } catch (Exception e) {
            throw new RuntimeException("Error executing SQL statement: " + e.getMessage(), e);
        }
    }
}