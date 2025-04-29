package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;

@Service
public class SalesReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public void insertSalesReport(String xmlData, Long managerId) {
        createTemporaryTable();
        try {
            String sql = buildInsertQuery(xmlData, managerId);
            jdbcTemplate.update(sql);
            insertAuditData(managerId);
        } catch (DataAccessException e) {
            // Handle exception (e.g., log the error, rethrow, etc.)
        }
    }

    private void createTemporaryTable() {
        String createTableSql = "CREATE TEMPORARY TABLE #SalesReport (id INT, order_id INT, product_id INT, quantity INT, total DECIMAL(10, 2))";
        jdbcTemplate.execute(createTableSql);
    }

    private String buildInsertQuery(String xmlData, Long managerId) {
        return "INSERT INTO #SalesReport (id, order_id, product_id, quantity, total) " +
               "SELECT * FROM (SELECT o.id, o.id AS order_id, sd.product_id, sd.quantity, sd.total " +
               "FROM Order o " +
               "JOIN Sales_data sd ON o.id = sd.order_id " +
               "JOIN Products p ON sd.product_id = p.id " +
               "WHERE p.active = 1 AND o.manager_id = ?) AS subquery";
    }

    private void insertAuditData(Long managerId) {
        // Logic to insert audit data based on managerId
    }
}