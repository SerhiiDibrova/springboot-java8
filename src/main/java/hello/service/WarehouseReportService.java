package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import hello.repository.WarehouseReportRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class WarehouseReportService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);
    private final JdbcTemplate jdbcTemplate;
    private final WarehouseReportRepository warehouseReportRepository;

    @Autowired
    public WarehouseReportService(JdbcTemplate jdbcTemplate, WarehouseReportRepository warehouseReportRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.warehouseReportRepository = warehouseReportRepository;
    }

    public void insertWarehouseReport(List<Long> orderIds) throws SQLException {
        if (orderIds == null || orderIds.isEmpty()) {
            throw new IllegalArgumentException("Order IDs must not be null or empty");
        }
        try {
            String createTableSql = "IF OBJECT_ID('tempdb..#WarehouseReport') IS NOT NULL DROP TABLE #WarehouseReport; " +
                                     "CREATE TABLE #WarehouseReport (OrderId BIGINT, WarehouseId BIGINT, Quantity INT);";
            jdbcTemplate.execute(createTableSql);

            warehouseReportRepository.insertWarehouseData(orderIds);
        } catch (DataAccessException e) {
            logger.error("Error inserting warehouse report: {}", e.getMessage());
            throw new SQLException("Error inserting warehouse report", e);
        }
    }
}