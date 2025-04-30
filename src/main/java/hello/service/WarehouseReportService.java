package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WarehouseReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);

    public void generateWarehouseReport() {
        String createTempItemsTable = "CREATE TABLE #TempItems (ItemID INT, Quantity INT);";
        String createWarehouseReportTable = "CREATE TABLE #WarehouseReport (OrderID INT, ProductID INT, WarehouseID INT, VendorID INT, BranchID INT, RegionID INT, EmployeeID INT, FinancialID INT);";
        String insertIntoWarehouseReport = "INSERT INTO #WarehouseReport (OrderID, ProductID, WarehouseID, VendorID, BranchID, RegionID, EmployeeID, FinancialID) " +
                "SELECT o.OrderID, p.ProductID, w.WarehouseID, v.VendorID, b.BranchID, r.RegionID, e.EmployeeID, f.FinancialID " +
                "FROM Orders o " +
                "INNER JOIN Inventory i ON o.ProductID = i.ProductID " +
                "INNER JOIN Warehouses w ON i.WarehouseID = w.WarehouseID " +
                "INNER JOIN Products p ON i.ProductID = p.ProductID " +
                "INNER JOIN Vendors v ON p.VendorID = v.VendorID " +
                "INNER JOIN Branches b ON w.BranchID = b.BranchID " +
                "INNER JOIN Regions r ON b.RegionID = r.RegionID " +
                "INNER JOIN Legacy_Logistics ll ON o.OrderID = ll.OrderID " +
                "INNER JOIN Employees e ON ll.EmployeeID = e.EmployeeID " +
                "INNER JOIN Legacy_Financials f ON o.OrderID = f.OrderID " +
                "WHERE i.Quantity > 0 AND o.Status IS NOT NULL AND EXISTS (SELECT 1 FROM #TempItems ti WHERE ti.ItemID = i.ProductID AND ti.Quantity > 0);";

        try {
            jdbcTemplate.execute(createTempItemsTable);
            jdbcTemplate.execute(createWarehouseReportTable);
            jdbcTemplate.execute(insertIntoWarehouseReport);
        } catch (Exception e) {
            logger.error("Error generating warehouse report", e);
        }
    }
}