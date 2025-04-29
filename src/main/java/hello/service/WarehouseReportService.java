package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;

@Service
public class WarehouseReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public String populateWarehouseReport() {
        try {
            if (!tempItemRepository.exists()) {
                return "Error: #TempItems table does not exist.";
            }

            jdbcTemplate.execute("CREATE TABLE #WarehouseReport (OrderId INT, ProductId INT, WarehouseId INT, Quantity INT, VendorId INT, BranchId INT, RegionId INT, LogisticsId INT, EmployeeId INT, FinancialId INT)");

            jdbcTemplate.execute("INSERT INTO #WarehouseReport SELECT o.OrderId, i.ProductId, i.WarehouseId, i.Quantity, p.VendorId, w.BranchId, b.RegionId, o.LogisticsId, o.EmployeeId, o.FinancialId " +
                "FROM Orders o " +
                "JOIN #TempItems t ON o.OrderId = t.OrderId " +
                "JOIN Inventory i ON o.OrderId = i.OrderId " +
                "JOIN Warehouses w ON i.WarehouseId = w.WarehouseId " +
                "JOIN Products p ON i.ProductId = p.ProductId " +
                "JOIN Vendors v ON p.VendorId = v.VendorId " +
                "JOIN Branches b ON w.BranchId = b.BranchId " +
                "JOIN Regions r ON b.RegionId = r.RegionId " +
                "JOIN Legacy_Logistics ll ON o.LogisticsId = ll.LogisticsId " +
                "JOIN Employees e ON o.EmployeeId = e.EmployeeId " +
                "JOIN Legacy_Financials lf ON o.FinancialId = lf.FinancialId " +
                "WHERE t.Condition = 'SomeCondition'");

            return "Warehouse report populated successfully.";
        } catch (DataAccessException e) {
            return "Error populating warehouse report: " + e.getMessage();
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }
}