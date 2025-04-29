package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WarehouseReportService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ErrorLogService errorLogService;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    public void populateWarehouseReport(Long orderId, String regionName, String productCategory, Integer stockLevel, Integer logisticsEfficiency) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE #WarehouseReport ( ")
           .append("id INT PRIMARY KEY, ")
           .append("orderId BIGINT, ")
           .append("regionName VARCHAR(255), ")
           .append("productCategory VARCHAR(255), ")
           .append("stockLevel INT, ")
           .append("logisticsEfficiency INT, ")
           .append("otherColumns VARCHAR(255) ); ");
        sql.append("INSERT INTO #WarehouseReport (id, orderId, regionName, productCategory, stockLevel, logisticsEfficiency) ")
           .append("SELECT ROW_NUMBER() OVER (ORDER BY o.id) AS id, o.id, w.regionName, i.productCategory, i.stockLevel, w.logisticsEfficiency ")
           .append("FROM Orders o ")
           .append("JOIN Inventory i ON o.productId = i.productId ")
           .append("JOIN Warehouses w ON i.warehouseId = w.id ")
           .append("WHERE 1=1 ");

        if (orderId != null) {
            sql.append("AND o.id = ? ");
        }
        if (regionName != null) {
            sql.append("AND w.regionName = ? ");
        }
        if (productCategory != null) {
            sql.append("AND i.productCategory = ? ");
        }
        if (stockLevel != null) {
            sql.append("AND i.stockLevel >= ? ");
        }
        if (logisticsEfficiency != null) {
            sql.append("AND w.logisticsEfficiency >= ? ");
        }

        try {
            jdbcTemplate.update(sql.toString(), orderId, regionName, productCategory, stockLevel, logisticsEfficiency);
        } catch (Exception e) {
            logger.error("Error populating warehouse report", e);
            errorLogService.logError(e);
        }
    }
}