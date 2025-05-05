package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class WarehouseReportRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportRepository.class);

    @Autowired
    public WarehouseReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeInsertWarehouseReport() {
        String sql = "INSERT INTO #WarehouseReport " +
                     "SELECT ... " + 
                     "FROM #TempItems t " +
                     "JOIN Orders o ON o.OrderId = t.OrderId " +
                     "JOIN Inventory i ON i.OrderId = o.OrderId " +
                     "JOIN Warehouses w ON w.WarehouseId = i.WarehouseId";

        try {
            jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            logger.error("Error executing insert into #WarehouseReport: {}", e.getMessage(), e);
        }
    }
}