package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WarehouseReportService {
    @Autowired
    private WarehouseReportRepository warehouseReportRepository;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);

    @Transactional
    public void populateWarehouseReport() {
        String createTempTableSQL = "CREATE TEMPORARY TABLE #WarehouseReport (WarehouseId INT, WarehouseName VARCHAR(255), WarehouseCapacity INT, OrderId INT, RegionName VARCHAR(255), BranchName VARCHAR(255), VendorName VARCHAR(255), ProductCategory VARCHAR(255), StockLevel INT, LogisticsEfficiency DECIMAL(10, 2));";
        jdbcTemplate.execute(createTempTableSQL);

        String insertSQL = "INSERT INTO #WarehouseReport SELECT w.WarehouseId, w.WarehouseName, w.WarehouseCapacity, o.OrderId, r.RegionName, b.BranchName, v.VendorName, p.ProductCategory, i.StockLevel, l.LogisticsEfficiency FROM #TempItems AS t JOIN Orders AS o ON o.OrderId = t.OrderId JOIN Inventory AS i ON i.OrderId = o.OrderId JOIN Warehouses AS w ON w.WarehouseId = i.WarehouseId JOIN Products AS p ON p.ProductId = i.ProductId JOIN Vendors AS v ON v.VendorId = p.VendorId JOIN Branches AS b ON b.BranchId = o.BranchId JOIN Regions AS r ON r.RegionId = b.RegionId JOIN Legacy_Logistics AS l ON l.WarehouseId = w.WarehouseId JOIN Employees AS e ON e.BranchId = b.BranchId JOIN Legacy_Financials AS f ON f.BranchId = b.BranchId WHERE (t.OrderId IS NULL OR o.OrderId = t.OrderId) AND (t.RegionName IS NULL OR r.RegionName = t.RegionName) AND (t.ProductCategory IS NULL OR p.ProductCategory = t.ProductCategory) AND (t.StockLevel IS NULL OR i.StockLevel >= t.StockLevel) AND (t.LogisticsEfficiency IS NULL OR l.LogisticsEfficiency >= t.LogisticsEfficiency);";

        try {
            jdbcTemplate.update(insertSQL);
        } catch (DataAccessException e) {
            logger.error("DataAccessException occurred: {}", e.getMessage());
            throw new CustomException("Error populating Warehouse Report", e);
        }
    }
}