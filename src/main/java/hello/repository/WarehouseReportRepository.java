package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WarehouseReportRepository {
    private final JdbcTemplate jdbcTemplate;

    public WarehouseReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeInsert(String sql) {
        jdbcTemplate.update(sql);
    }
}