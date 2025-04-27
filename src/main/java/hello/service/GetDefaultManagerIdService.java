package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GetDefaultManagerIdService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(GetDefaultManagerIdService.class);

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId != null && managerId >= 0) {
            return managerId;
        }

        Integer defaultManagerId = null;
        try {
            String sql = "SELECT default_manager_id FROM users WHERE criteria = ?";
            defaultManagerId = jdbcTemplate.queryForObject(sql, new Object[]{/* criteria value */}, Integer.class);
        } catch (Exception e) {
            logger.error("Error retrieving default manager ID", e);
        }
        return defaultManagerId;
    }
}