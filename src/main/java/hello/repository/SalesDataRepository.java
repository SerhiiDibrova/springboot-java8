

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;

import javax.sql.DataSource;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public interface SalesDataRepository extends JpaRepository<SalesData, Long> {

    List<SalesData> findAll();

    @Query("SELECT s FROM SalesData s WHERE s.orderId = :orderId")
    List<SalesData> findByOrderId(Long orderId);

    default List<SalesData> findByOrderIdWithJdbcTemplate(Long orderId, JdbcTemplate jdbcTemplate) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }

        String query = "SELECT * FROM sales_data WHERE order_id = ?";

        try {
            return jdbcTemplate.query(query, new Object[]{orderId}, new SalesDataRowMapper());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving sales data by order ID", e);
        }
    }

    private static class SalesDataRowMapper implements RowMapper<SalesData> {
        @Override
        public SalesData mapRow(ResultSet rs, int rowNum) throws SQLException {
            SalesData salesData = new SalesData();
            salesData.setId(rs.getLong("id"));
            salesData.setOrderId(rs.getLong("order_id"));
            // Add additional fields as needed
            return salesData;
        }
    }
}