package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.logging.Logger;

@Service
public class SalesReportService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private SalesReportRepository salesReportRepository;

    private static final Logger logger = Logger.getLogger(SalesReportService.class.getName());

    @Transactional
    public void generateSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        try {
            entityManager.createNativeQuery("CREATE TABLE #SalesReport (OrderId INT, ManagerId INT, Sales_Status VARCHAR(50), Discount_Status VARCHAR(50), Performance_Status VARCHAR(50))").executeUpdate();
            String sql = "INSERT INTO #SalesReport (OrderId, ManagerId, Sales_Status, Discount_Status, Performance_Status) " +
                         "SELECT o.OrderId, s.ManagerId, " +
                         "CASE WHEN s.TotalSales > 1000 THEN 'High' ELSE 'Low' END AS Sales_Status, " +
                         "CASE WHEN d.DiscountAmount > 0 THEN 'Applied' ELSE 'Not Applied' END AS Discount_Status, " +
                         "CASE WHEN p.PerformanceScore > 75 THEN 'Good' ELSE 'Needs Improvement' END AS Performance_Status " +
                         "FROM Orders o " +
                         "JOIN Sales s ON o.OrderId = s.OrderId " +
                         "LEFT JOIN Discounts d ON o.OrderId = d.OrderId " +
                         "LEFT JOIN Products p ON o.ProductId = p.ProductId " +
                         "WHERE o.StockLevel = 0";
            jdbcTemplate.update(sql);

            if (isAuditNeeded) {
                Integer defaultManagerId = getDefaultManagerId();
                logAuditData(defaultManagerId, xmlData);
            }

            validateData();
        } catch (Exception e) {
            logger.severe("Error generating sales report: " + e.getMessage());
            throw e;
        }
    }

    private Integer getDefaultManagerId() {
        return 1;
    }

    private void logAuditData(Integer managerId, String xmlData) {
        // Logic to log audit data
    }

    private void validateData() {
        // Validation logic for data
    }
}