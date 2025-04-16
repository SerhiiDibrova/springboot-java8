

package hello.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class GetSalesData {

    private final JdbcTemplate jdbcTemplate;

    public GetSalesData(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<SalesData> getSalesData(String nameFilter, BigDecimal amountFilter) {
        try {
            jdbcTemplate.execute("CREATE TABLE #SalesReport (id INT, name VARCHAR(255), amount DECIMAL(10, 2))");
            jdbcTemplate.update("INSERT INTO #SalesReport (id, name, amount) VALUES (1, 'Product A', 100.00)");
            jdbcTemplate.update("INSERT INTO #SalesReport (id, name, amount) VALUES (2, 'Product B', 200.00)");
            jdbcTemplate.update("INSERT INTO #SalesReport (id, name, amount) VALUES (3, 'Product C', 300.00)");

            String query = "SELECT * FROM #SalesReport";
            if (nameFilter != null && !nameFilter.isEmpty()) {
                query += " WHERE name LIKE '%" + nameFilter + "%'";
            }
            if (amountFilter != null) {
                if (nameFilter == null || nameFilter.isEmpty()) {
                    query += " WHERE";
                } else {
                    query += " AND";
                }
                query += " amount > " + amountFilter.toString();
            }

            List<SalesData> salesDataList = jdbcTemplate.query(query, new SalesDataRowMapper());
            jdbcTemplate.execute("DROP TABLE #SalesReport");
            return salesDataList;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error getting sales data", e);
        }
    }

    private static class SalesDataRowMapper implements RowMapper<SalesData> {
        @Override
        public SalesData mapRow(ResultSet rs, int rowNum) throws SQLException {
            SalesData salesData = new SalesData();
            salesData.setId(rs.getInt("id"));
            salesData.setName(rs.getString("name"));
            salesData.setAmount(rs.getBigDecimal("amount"));
            return salesData;
        }
    }
}

class SalesData {
    private int id;
    private String name;
    private java.math.BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }
}