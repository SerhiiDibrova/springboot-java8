package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.repository.WarehouseReportRepository;

@Service
public class WarehouseReportService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertWarehouseReportData(String orderId, String regionName, String productCategory, String productId, int quantity, double price) {
        String createTempTableSql = "CREATE TEMPORARY TABLE temp_warehouse_report AS SELECT * FROM WarehouseReport WHERE 1=0";
        String insertDataSql = "INSERT INTO WarehouseReport (OrderId, RegionName, ProductCategory, ProductId, Quantity, Price) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.execute(createTempTableSql);
            jdbcTemplate.update(insertDataSql, orderId, regionName, productCategory, productId, quantity, price);
        } catch (DataAccessException e) {
            logger.error("Data access error while inserting warehouse report data", e);
        } catch (Exception e) {
            logger.error("Error inserting warehouse report data", e);
        }
    }
}