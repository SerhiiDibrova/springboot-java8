package hello.service;

import hello.model.SalesDataResponse;
import hello.model.TempItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesDataService {
    private final JdbcTemplate jdbcTemplate;

    public SalesDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SalesDataResponse> getSalesData(Long orderId, List<TempItem> tempItems) {
        if (tempItems == null || tempItems.isEmpty()) {
            return Collections.emptyList();
        }

        String itemIds = tempItems.stream()
                                   .map(TempItem::getItemId)
                                   .map(String::valueOf)
                                   .collect(Collectors.joining(","));

        String sql = "SELECT sd.* FROM sales_data sd " +
                     "LEFT JOIN order_data od ON sd.order_id = od.id " +
                     "WHERE od.id = ? AND sd.item_id IN (" + itemIds + ")";

        return jdbcTemplate.query(sql, new Object[]{orderId}, 
            (rs, rowNum) -> new SalesDataResponse(
                rs.getLong("id"),
                rs.getLong("order_id"),
                rs.getLong("item_id"),
                rs.getInt("quantity"),
                rs.getBigDecimal("price")
            ));
    }
}