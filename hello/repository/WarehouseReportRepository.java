package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WarehouseReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public WarehouseReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTempWarehouseReportTable() {
        String sql = "CREATE TEMPORARY TABLE temp_warehouse_report AS SELECT * FROM warehouse_report WHERE 1=0";
        jdbcTemplate.execute(sql);
    }

    public void insertWarehouseReportData(String data) {
        String sql = "INSERT INTO temp_warehouse_report (column1, column2) VALUES (?, ?)";
        jdbcTemplate.update(sql, data.split(",")[0], data.split(",")[1]);
    }
}