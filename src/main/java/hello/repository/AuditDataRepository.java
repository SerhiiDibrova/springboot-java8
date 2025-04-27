package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import hello.model.AuditDataDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditDataRepository {

    private final JdbcTemplate jdbcTemplate;

    public AuditDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTempAuditTable() {
        String sql = "CREATE TEMPORARY TABLE audit_data (id SERIAL PRIMARY KEY, action VARCHAR(255), timestamp TIMESTAMP, user_id INT, details TEXT)";
        jdbcTemplate.execute(sql);
    }

    public void insertAuditRecord(String action, LocalDateTime timestamp, int userId, String details) {
        String sql = "INSERT INTO audit_data (action, timestamp, user_id, details) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, action, timestamp, userId, details);
    }

    public List<AuditDataDTO> fetchAuditData() {
        String sql = "SELECT * FROM audit_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new AuditDataDTO(rs.getInt("id"), rs.getString("action"), rs.getTimestamp("timestamp").toLocalDateTime(), rs.getInt("user_id"), rs.getString("details")));
    }

    public void cleanupAuditTable() {
        String sql = "DROP TABLE IF EXISTS audit_data";
        jdbcTemplate.execute(sql);
    }
}