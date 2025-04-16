

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSalesData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GetSalesData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Object> getSalesData() {
        String query = "SELECT * FROM temp_sales_data";
        return jdbcTemplate.queryForList(query);
    }
}