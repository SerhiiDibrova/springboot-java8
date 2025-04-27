package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import hello.model.SalesDataDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class SalesDataRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SalesDataDTO> fetchSalesData(int orderId, List<Item> tempItems) {
        String sql = "SELECT * FROM sales_data WHERE order_id = ?";
        return jdbcTemplate.query(sql, new Object[]{orderId}, (rs, rowNum) -> {
            SalesDataDTO salesData = new SalesDataDTO();
            salesData.setId(rs.getLong("id"));
            salesData.setOrderId(rs.getInt("order_id"));
            salesData.setItemName(rs.getString("item_name"));
            salesData.setQuantity(rs.getInt("quantity"));
            salesData.setPrice(rs.getDouble("price"));
            return salesData;
        });
    }
}