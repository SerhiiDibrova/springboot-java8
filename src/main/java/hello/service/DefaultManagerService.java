package hello.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DefaultManagerService {
    private final JdbcTemplate jdbcTemplate;

    public DefaultManagerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            try {
                String sql = "SELECT id FROM users WHERE is_default_manager = true LIMIT 1";
                managerId = jdbcTemplate.queryForObject(sql, Integer.class);
            } catch (Exception e) {
                // Handle exception (e.g., log it)
            }
        }
        return managerId;
    }
}