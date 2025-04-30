package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.repository.WarehouseReportRepository;
import hello.repository.TempItemRepository;
import hello.entity.WarehouseReport;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WarehouseReportService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public void populateWarehouseReport() {
        String checkTempItemsQuery = "IF OBJECT_ID('tempdb..#TempItems') IS NOT NULL " +
                                      "BEGIN " +
                                      "IF NOT EXISTS (SELECT * FROM tempdb..#TempItems WHERE OrderId IS NOT NULL) " +
                                      "BEGIN " +
                                      "RAISERROR('OrderId column is missing in #TempItems', 16, 1) " +
                                      "RETURN; " +
                                      "END " +
                                      "END";

        String createWarehouseReportTableQuery = "CREATE TABLE #WarehouseReport (" +
                                                  "OrderId INT, " +
                                                  "ProductName NVARCHAR(255), " +
                                                  "VendorName NVARCHAR(255), " +
                                                  "WarehouseLocation NVARCHAR(255), " +
                                                  "BranchName NVARCHAR(255), " +
                                                  "RegionName NVARCHAR(255), " +
                                                  "EmployeeName NVARCHAR(255), " +
                                                  "FinancialData NVARCHAR(255))";

        String insertDataQuery = "INSERT INTO #WarehouseReport (OrderId, ProductName, VendorName, WarehouseLocation, BranchName, RegionName, EmployeeName, FinancialData) " +
                                  "SELECT o.OrderId, p.ProductName, v.VendorName, w.Location, b.BranchName, r.RegionName, e.EmployeeName, f.FinancialData " +
                                  "FROM Orders o " +
                                  "JOIN Products p ON o.ProductId = p.Id " +
                                  "JOIN Vendors v ON p.VendorId = v.Id " +
                                  "JOIN Warehouses w ON o.WarehouseId = w.Id " +
                                  "JOIN Branches b ON w.BranchId = b.Id " +
                                  "JOIN Regions r ON b.RegionId = r.Id " +
                                  "JOIN Employees e ON o.EmployeeId = e.Id " +
                                  "JOIN Legacy_Logistics l ON o.OrderId = l.OrderId " +
                                  "JOIN Legacy_Financials f ON o.OrderId = f.OrderId " +
                                  "WHERE EXISTS (SELECT 1 FROM #TempItems ti WHERE ti.OrderId = o.OrderId)";

        try {
            warehouseReportRepository.getEntityManager().createNativeQuery(checkTempItemsQuery).executeUpdate();
            warehouseReportRepository.getEntityManager().createNativeQuery(createWarehouseReportTableQuery).executeUpdate();
            warehouseReportRepository.getEntityManager().createNativeQuery(insertDataQuery).executeUpdate();
        } catch (Exception e) {
            logger.error("Error populating WarehouseReport", e);
            throw new DataInsertionException("Error populating WarehouseReport", e);
        }
    }
}