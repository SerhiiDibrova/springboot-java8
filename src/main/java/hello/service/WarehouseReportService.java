package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseReportService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void populateWarehouseReport() {
        try {
            jdbcTemplate.execute("IF OBJECT_ID('tempdb..#WarehouseReport') IS NOT NULL DROP TABLE #WarehouseReport; " +
                                 "CREATE TABLE #WarehouseReport (Column1 DataType1, Column2 DataType2, ...);");
            String sql = "INSERT INTO #WarehouseReport (Column1, Column2, ...) " +
                         "SELECT a.Column1, b.Column2, ... " +
                         "FROM Orders a " +
                         "JOIN Inventory b ON a.InventoryId = b.Id " +
                         "JOIN Warehouses c ON b.WarehouseId = c.Id " +
                         "JOIN Products d ON b.ProductId = d.Id " +
                         "JOIN Vendors e ON d.VendorId = e.Id " +
                         "JOIN Branches f ON e.BranchId = f.Id " +
                         "JOIN Regions g ON f.RegionId = g.Id " +
                         "JOIN Legacy_Logistics h ON a.LogisticsId = h.Id " +
                         "JOIN Employees i ON a.EmployeeId = i.Id " +
                         "JOIN Legacy_Financials j ON a.FinancialId = j.Id " +
                         "JOIN #TempItems k ON a.ItemId = k.ItemId " +
                         "WHERE k.SomeColumn IS NOT NULL AND a.Status = 'Active' AND b.Quantity > 0;";
            jdbcTemplate.update(sql);
        } catch (SQLException e) {
            logger.error("SQL Error populating WarehouseReport: ", e);
            throw e;
        } catch (Exception e) {
            logger.error("Error populating WarehouseReport: ", e);
            throw e;
        }
    }
}