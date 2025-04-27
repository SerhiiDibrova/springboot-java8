package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSalesDataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SalesData> getSalesData(int orderId, List<TempItem> tempItems) {
        if (orderId <= 0 || tempItems == null || tempItems.isEmpty()) {
            throw new IllegalArgumentException("Invalid orderId or tempItems");
        }

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT sd.* FROM SalesData sd ")
           .append("LEFT JOIN OrderData od ON sd.order_id = od.id ")
           .append("LEFT JOIN TempItem ti ON sd.item_id = ti.id ")
           .append("WHERE od.id = ? AND ti.id IN (");

        for (int i = 0; i < tempItems.size(); i++) {
            sql.append("?");
            if (i < tempItems.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");

        Object[] params = new Object[tempItems.size() + 1];
        params[0] = orderId;
        for (int i = 0; i < tempItems.size(); i++) {
            params[i + 1] = tempItems.get(i).getId();
        }

        return jdbcTemplate.query(sql.toString(), params, (rs, rowNum) -> {
            SalesData salesData = new SalesData();
            salesData.setId(rs.getInt("id"));
            salesData.setOrderId(rs.getInt("order_id"));
            salesData.setAmount(rs.getDouble("amount"));
            salesData.setItemId(rs.getInt("item_id"));
            salesData.setQuantity(rs.getInt("quantity"));
            salesData.setPrice(rs.getDouble("price"));
            return salesData;
        });
    }
}