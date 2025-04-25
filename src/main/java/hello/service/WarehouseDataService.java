package hello.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class WarehouseDataService {

    private final JdbcTemplate jdbcTemplate;

    public WarehouseDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WarehouseDataResponse> getWarehouseData(List<TempItem> tempItems) {
        if (tempItems == null || tempItems.isEmpty()) {
            throw new IllegalArgumentException("TempItems list cannot be null or empty");
        }

        String createTempTableSQL = "CREATE TEMPORARY TABLE temp_items (id INT, name VARCHAR(255), quantity INT)";
        try {
            jdbcTemplate.execute(createTempTableSQL);

            String insertTempItemsSQL = "INSERT INTO temp_items (id, name, quantity) VALUES (?, ?, ?)";
            jdbcTemplate.batchUpdate(insertTempItemsSQL, tempItems, tempItems.size(),
                (PreparedStatement ps, TempItem tempItem) -> {
                    ps.setInt(1, tempItem.getId());
                    ps.setString(2, tempItem.getName());
                    ps.setInt(3, tempItem.getQuantity());
                });

            String querySQL = "SELECT w.id, w.name, o.order_id, i.stock " +
                              "FROM temp_items ti " +
                              "JOIN Orders o ON ti.id = o.item_id " +
                              "JOIN Inventory i ON ti.id = i.item_id " +
                              "JOIN Warehouses w ON i.warehouse_id = w.id";

            return jdbcTemplate.query(querySQL, (rs, rowNum) -> {
                WarehouseDataResponse response = new WarehouseDataResponse();
                response.setWarehouseId(rs.getInt("id"));
                response.setWarehouseName(rs.getString("name"));
                response.setOrderId(rs.getInt("order_id"));
                response.setStock(rs.getInt("stock"));
                return response;
            });
        } catch (SQLException e) {
            throw new RuntimeException("Database operation failed", e);
        }
    }
}