

package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;

@Repository
public class CreateTemporaryTablesRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTemporaryTablesRepository.class);

    private final JdbcTemplate jdbcTemplate;

    public CreateTemporaryTablesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTempItemsTable() {
        String sql = "CREATE TEMPORARY TABLE IF NOT EXISTS temp_items (id INT, name VARCHAR(255))";
        try {
            jdbcTemplate.execute(sql);
            LOGGER.info("Temporary table 'temp_items' created successfully");
        } catch (DataAccessException e) {
            LOGGER.error("Error creating temporary table 'temp_items'", e);
            throw e;
        }
    }

    public void createWarehouseReportTable() {
        String sql = "CREATE TEMPORARY TABLE IF NOT EXISTS warehouse_report (id INT, item_id INT, quantity INT)";
        try {
            jdbcTemplate.execute(sql);
            LOGGER.info("Temporary table 'warehouse_report' created successfully");
        } catch (DataAccessException e) {
            LOGGER.error("Error creating temporary table 'warehouse_report'", e);
            throw e;
        }
    }

    public void createSalesReportTable() {
        String sql = "CREATE TEMPORARY TABLE IF NOT EXISTS sales_report (id INT, item_id INT, quantity INT, date DATE)";
        try {
            jdbcTemplate.execute(sql);
            LOGGER.info("Temporary table 'sales_report' created successfully");
        } catch (DataAccessException e) {
            LOGGER.error("Error creating temporary table 'sales_report'", e);
            throw e;
        }
    }
}