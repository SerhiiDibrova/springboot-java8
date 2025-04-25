package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class WarehouseDataRepositoryImpl implements WarehouseDataRepository {
    private final JdbcTemplate jdbcTemplate;

    public WarehouseDataRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WarehouseDataResponse> findAll() {
        String sql = "SELECT * FROM warehouse_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new WarehouseDataResponse(rs.getLong("id"), rs.getString("name"), rs.getInt("quantity")));
    }

    @Override
    public WarehouseDataResponse findById(Long id) {
        String sql = "SELECT * FROM warehouse_data WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new WarehouseDataResponse(rs.getLong("id"), rs.getString("name"), rs.getInt("quantity")));
    }

    @Override
    public void save(WarehouseDataResponse warehouseData) {
        String sql = "INSERT INTO warehouse_data (name, quantity) VALUES (?, ?)";
        jdbcTemplate.update(sql, warehouseData.getName(), warehouseData.getQuantity());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM warehouse_data WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}