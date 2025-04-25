package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InsertSalesReportService {
    private static final Logger logger = LoggerFactory.getLogger(InsertSalesReportService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertSalesReport() {
        createTempTable();
        insertData();
    }

    private void createTempTable() {
        String createTempTableSql = "CREATE TEMPORARY TABLE temp_sales_report AS " +
                                     "SELECT a.id, a.amount, b.name FROM sales a LEFT JOIN products b ON a.product_id = b.id";
        try {
            jdbcTemplate.execute(createTempTableSql);
            logger.info("Temporary table created successfully.");
        } catch (Exception e) {
            logger.error("Error creating temporary table: ", e);
        }
    }

    private void insertData() {
        String insertDataSql = "INSERT INTO temp_sales_report (id, amount, name) SELECT id, amount, name FROM sales";
        try {
            jdbcTemplate.execute(insertDataSql);
            logger.info("Data inserted into temporary table successfully.");
        } catch (Exception e) {
            logger.error("Error inserting data into temporary table: ", e);
        }
    }
}