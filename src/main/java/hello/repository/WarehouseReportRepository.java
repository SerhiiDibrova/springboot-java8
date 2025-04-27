package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReportRepository extends org.springframework.data.repository.Repository<Object, Long> {
    void executeInsert(String sql);
}