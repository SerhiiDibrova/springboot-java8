

package hello.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import hello.model.SalesData;

@Repository
public class SalesReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public SalesReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SalesData> getSalesData() {
        String sql = "SELECT * FROM sales_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new SalesData(rs.getLong("id"), rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("warehouse")));
    }

    public List<SalesData> getWarehouseReportData(String warehouse) {
        String sql = "SELECT * FROM sales_data WHERE warehouse = ?";
        return jdbcTemplate.query(sql, new Object[]{warehouse}, (rs, rowNum) -> new SalesData(rs.getLong("id"), rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price"), rs.getString("warehouse")));
    }
}