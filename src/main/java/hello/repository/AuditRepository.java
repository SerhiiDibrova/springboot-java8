package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public class AuditRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void executeInsertAuditData(String createTempTableSQL, String insertSQL, Integer managerId) {
        jdbcTemplate.execute(createTempTableSQL);
        jdbcTemplate.update(insertSQL, managerId);
    }

    public List<Object[]> findAuditDataByManagerId(@Param("managerId") Integer managerId) {
        String sql = "SELECT a.id, ar.details, ar.created_at " +
                     "FROM audit AS a " +
                     "JOIN audit_record AS ar ON a.id = ar.audit_id " +
                     "WHERE a.manager_id = ? AND a.type = 'SALES'";
        return jdbcTemplate.query(sql, new Object[]{managerId}, (rs, rowNum) -> new Object[]{
            rs.getInt("id"),
            rs.getString("details"),
            rs.getTimestamp("created_at")
        });
    }
}