package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;

@Service
public class SomeService {

    private final JdbcTemplate jdbcTemplate;
    private final ErrorLogService errorLogService;

    @Autowired
    public SomeService(JdbcTemplate jdbcTemplate, ErrorLogService errorLogService) {
        this.jdbcTemplate = jdbcTemplate;
        this.errorLogService = errorLogService;
    }

    public void executeSqlOperation(String sql, Object... args) {
        try {
            jdbcTemplate.update(sql, args);
        } catch (DataAccessException e) {
            errorLogService.logError(e.getMessage(), "HIGH", e.getSQLState());
        }
    }

    public void validateAndExecute(String sql, Object... args) {
        if (isValidSql(sql)) {
            executeSqlOperation(sql, args);
        } else {
            errorLogService.logError("Invalid SQL statement: " + sql, "MEDIUM", null);
        }
    }

    private boolean isValidSql(String sql) {
        return sql != null && !sql.trim().isEmpty();
    }
}