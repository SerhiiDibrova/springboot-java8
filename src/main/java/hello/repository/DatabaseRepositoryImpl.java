package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseRepositoryImpl implements DatabaseRepository {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void Save(String data) {
        String sql = "INSERT INTO reports (data) VALUES (?)";
        jdbcTemplate.update(sql, data);
    }
}