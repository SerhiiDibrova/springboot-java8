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
    public void populateSalesReport() {
        String sql = "INSERT INTO SalesReport (column1, column2, column3, column4) " +
                     "SELECT a.column1, b.column2, a.column3, 'defaultStatus' " +
                     "FROM TableA a " +
                     "JOIN TableB b ON a.id = b.a_id " +
                     "WHERE a.StockLevel > ?";

        try {
            jdbcTemplate.update(sql, 0);
        } catch (Exception e) {
            logger.error("Error populating SalesReport: ", e);
        }
    }
}