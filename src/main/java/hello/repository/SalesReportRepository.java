

package hello.repository;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Repository
public class SalesReportRepository {

    private JdbcTemplate jdbcTemplate;

    public SalesReportRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createSalesReportTable() {
        String query = "CREATE TABLE sales_report (" +
                "id INT PRIMARY KEY, " +
                "product_name VARCHAR(255), " +
                "quantity INT, " +
                "total_price DECIMAL(10, 2))";
        jdbcTemplate.execute(query);
    }
}