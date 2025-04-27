package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultManagerRepository {
    JdbcTemplate jdbcTemplate = null;

    default Long findDefaultManagerId() {
        String sql = "SELECT id FROM users WHERE role = 'MANAGER' AND is_default = true";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}