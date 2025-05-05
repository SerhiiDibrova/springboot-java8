package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WarehouseReportService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WarehouseReportService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean insertWarehouseReport(List<Long> orderIds) {
        if (orderIds == null || orderIds.isEmpty()) {
            logger.warn("Input orderIds is null or empty.");
            return false;
        }
        try {
            String createTableSql = "IF OBJECT_ID('tempdb..#WarehouseReport') IS NOT NULL DROP TABLE #WarehouseReport; " +
                                     "CREATE TABLE #WarehouseReport (OrderId BIGINT, WarehouseId BIGINT, Quantity INT);";
            jdbcTemplate.execute(createTableSql);

            String insertSql = "INSERT INTO #WarehouseReport " +
                    "SELECT t.OrderId, w.WarehouseId, SUM(t.Quantity) " +
                    "FROM #TempItems t " +
                    "JOIN Orders o ON o.OrderId = t.OrderId " +
                    "JOIN Inventory i ON i.OrderId = o.OrderId " +
                    "JOIN Warehouses w ON w.WarehouseId = i.WarehouseId " +
                    "WHERE t.OrderId IN (" + String.join(",", orderIds.stream().map(String::valueOf).toArray(String[]::new)) + ") " +
                    "GROUP BY t.OrderId, w.WarehouseId;";
            jdbcTemplate.execute(insertSql);

            return true;
        } catch (DataAccessException e) {
            logger.error("Error inserting warehouse report: ", e);
            return false;
        }
    }
}