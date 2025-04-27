package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TempItemsRepository {

    private final JdbcTemplate jdbcTemplate;

    public TempItemsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTempItemsTable() {
        String sql = "CREATE TEMPORARY TABLE temp_items (id INT PRIMARY KEY, name VARCHAR(255))";
        jdbcTemplate.execute(sql);
    }

    public List<String> fetchDisplayOptions() {
        String sql = "SELECT ti.name FROM temp_items ti JOIN config_table ct ON ti.id = ct.item_id";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public void cleanupTempItemsTable() {
        String sql = "DROP TABLE IF EXISTS temp_items";
        jdbcTemplate.execute(sql);
    }
}