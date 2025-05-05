package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class WarehouseReportRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WarehouseReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeInsertWarehouseReport(String sql) {
        jdbcTemplate.update(sql);
    }
}