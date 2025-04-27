package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import hello.model.WarehouseData;
import hello.model.TempItem;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class GetWarehouseDataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<WarehouseData> getWarehouseData(List<TempItem> tempItems) {
        if (tempItems.isEmpty()) {
            return List.of();
        }

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT w.id, w.name, i.quantity, o.order_date ")
           .append("FROM Warehouses w ")
           .append("JOIN Inventory i ON w.id = i.warehouse_id ")
           .append("JOIN Orders o ON i.item_id = o.item_id ")
           .append("WHERE i.item_id IN (");

        for (int i = 0; i < tempItems.size(); i++) {
            sql.append("?");
            if (i < tempItems.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");

        try {
            return jdbcTemplate.query(sql.toString(), new RowMapper<WarehouseData>() {
                @Override
                public WarehouseData mapRow(ResultSet rs, int rowNum) throws SQLException {
                    WarehouseData warehouseData = new WarehouseData();
                    warehouseData.setId(rs.getLong("id"));
                    warehouseData.setName(rs.getString("name"));
                    warehouseData.setQuantity(rs.getInt("quantity"));
                    warehouseData.setOrderDate(rs.getDate("order_date"));
                    return warehouseData;
                }
            }, tempItems.stream().map(TempItem::getItemId).toArray());
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving warehouse data", e);
        }
    }
}