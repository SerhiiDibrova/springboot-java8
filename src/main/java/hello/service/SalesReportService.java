package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SalesReportService {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public String populateSalesReport() {
        String sql = "INSERT INTO #SalesReport (Sales_Status, Discount_Status, Performance_Status) " +
                     "SELECT CASE WHEN SUM(SalesAmount) > 10000 THEN 'High' ELSE 'Low' END AS Sales_Status, " +
                     "CASE WHEN SUM(Discount) > 500 THEN 'High' ELSE 'Low' END AS Discount_Status, " +
                     "CASE WHEN AVG(Performance) > 75 THEN 'Good' ELSE 'Poor' END AS Performance_Status " +
                     "FROM SalesData " +
                     "JOIN #WarehouseReport ON SalesData.WarehouseId = #WarehouseReport.WarehouseId " +
                     "WHERE #WarehouseReport.StockLevel > 0 " +
                     "GROUP BY SalesData.ProductId";

        try {
            int recordsInserted = jdbcTemplate.update(sql);
            return "Successfully inserted " + recordsInserted + " records into #SalesReport.";
        } catch (Exception e) {
            logger.error("Error populating SalesReport: ", e);
            return "Error occurred while populating SalesReport.";
        }
    }
}