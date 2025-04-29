package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SalesReportService {

    private final JdbcTemplate jdbcTemplate;
    private final SalesReportRepository salesReportRepository;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    public SalesReportService(JdbcTemplate jdbcTemplate, SalesReportRepository salesReportRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.salesReportRepository = salesReportRepository;
    }

    @Transactional
    public void generateSalesReport() {
        String sql = "INSERT INTO #SalesReport (columns) " +
                     "SELECT aggregated_columns FROM Orders o " +
                     "JOIN Sales s ON o.id = s.order_id " +
                     "JOIN Inventory i ON s.product_id = i.product_id " +
                     "JOIN Products p ON i.product_id = p.id " +
                     "WHERE i.StockLevel = 0";

        try {
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            logger.error("Error generating sales report: ", e);
            throw e;
        }
    }

    private Optional<Object> handleNullValues(Object value) {
        return Optional.ofNullable(value);
    }
}