package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class WarehouseReportService {

    private final ErrorHandlingService errorHandlingService;
    private final WarehouseReportRepository warehouseReportRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WarehouseReportService(ErrorHandlingService errorHandlingService, WarehouseReportRepository warehouseReportRepository, JdbcTemplate jdbcTemplate) {
        this.errorHandlingService = errorHandlingService;
        this.warehouseReportRepository = warehouseReportRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void generateWarehouseReport() {
        try {
            jdbcTemplate.execute("CREATE TABLE #WarehouseReport (orderId INT, warehouseId INT, stockLevel INT, capacity INT, logisticsMetric INT);");
            jdbcTemplate.execute("INSERT INTO #WarehouseReport (orderId, warehouseId, stockLevel, capacity, logisticsMetric) " +
                                 "SELECT t.OrderId, w.WarehouseId, i.StockLevel, w.Capacity, i.LogisticsMetric " +
                                 "FROM #TempItems t " +
                                 "JOIN Orders o ON o.OrderId = t.OrderId " +
                                 "JOIN Inventory i ON i.OrderId = o.OrderId " +
                                 "JOIN Warehouses w ON w.WarehouseId = i.WarehouseId;");

            // Assuming the report data needs to be fetched from the temporary table
            List<WarehouseReport> reports = jdbcTemplate.query("SELECT * FROM #WarehouseReport", new WarehouseReportRowMapper());
            warehouseReportRepository.saveAll(reports);

        } catch (SQLException e) {
            errorHandlingService.logError(e);
        }
    }
}