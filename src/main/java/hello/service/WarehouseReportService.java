package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseReportService {

    private final JdbcTemplate jdbcTemplate;
    private final ErrorHandlingService errorHandlingService;
    private final WarehouseReportRepository warehouseReportRepository;

    @Autowired
    public WarehouseReportService(JdbcTemplate jdbcTemplate, ErrorHandlingService errorHandlingService, WarehouseReportRepository warehouseReportRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.errorHandlingService = errorHandlingService;
        this.warehouseReportRepository = warehouseReportRepository;
    }

    @Transactional
    public void populateWarehouseReport() {
        try {
            jdbcTemplate.execute("CREATE TABLE #WarehouseReport (OrderId INT, ProductId INT, WarehouseId INT, Quantity INT, TotalValue DECIMAL(10, 2));");
            jdbcTemplate.execute("INSERT INTO #WarehouseReport (OrderId, ProductId, WarehouseId, Quantity, TotalValue) " +
                    "SELECT o.OrderId, p.ProductId, w.WarehouseId, SUM(i.Quantity) AS Quantity, SUM(i.Quantity * p.Price) AS TotalValue " +
                    "FROM #TempItems ti " +
                    "INNER JOIN Orders o ON ti.OrderId = o.OrderId " +
                    "INNER JOIN Inventory i ON o.InventoryId = i.InventoryId " +
                    "INNER JOIN Warehouses w ON i.WarehouseId = w.WarehouseId " +
                    "INNER JOIN Products p ON i.ProductId = p.ProductId " +
                    "INNER JOIN Vendors v ON p.VendorId = v.VendorId " +
                    "INNER JOIN Branches b ON w.BranchId = b.BranchId " +
                    "INNER JOIN Regions r ON b.RegionId = r.RegionId " +
                    "INNER JOIN Legacy_Logistics ll ON o.LogisticsId = ll.LogisticsId " +
                    "INNER JOIN Employees e ON o.EmployeeId = e.EmployeeId " +
                    "INNER JOIN Legacy_Financials lf ON o.FinancialId = lf.FinancialId " +
                    "WHERE (ti.SomeField IS NULL OR ti.SomeField = 'SomeValue') " +
                    "AND (o.AnotherField IS NULL OR o.AnotherField = 'AnotherValue') " +
                    "GROUP BY o.OrderId, p.ProductId, w.WarehouseId;");
        } catch (Exception e) {
            errorHandlingService.logError(e);
        }
    }
}