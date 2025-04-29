package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalesReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void populateSalesReport() {
        String sql = "CREATE TABLE #SalesReport AS " +
                     "SELECT o.order_id, sd.sales_data, ti.item_id, p.product_name, c.customer_name, d.discount_amount, s.shipment_date " +
                     "FROM Orders o " +
                     "JOIN Sales_data sd ON o.order_id = sd.order_id " +
                     "JOIN TempItems ti ON sd.item_id = ti.item_id " +
                     "JOIN Products p ON ti.product_id = p.product_id " +
                     "JOIN Customers c ON o.customer_id = c.customer_id " +
                     "LEFT JOIN Discounts d ON o.discount_id = d.discount_id AND d.active = true " +
                     "JOIN Shipments s ON o.shipment_id = s.shipment_id " +
                     "WHERE o.status = 'active' AND sd.valid = true AND p.active = true AND c.active = true";

        try {
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException("Error populating sales report", e);
        } finally {
            jdbcTemplate.execute("DROP TABLE IF EXISTS #SalesReport");
        }
    }
}