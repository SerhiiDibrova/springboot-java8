package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import hello.model.SalesReportResponse;

import java.sql.SQLException;
import java.util.List;

public interface SalesReportRepositoryInterface {
    void insertIntoTemporaryTable(String sql) throws SQLException;
    List<SalesReportResponse> retrieveAuditData(String sql) throws SQLException;
}

@Repository
public class SalesReportRepository implements SalesReportRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;

    public SalesReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertIntoTemporaryTable(String sql) throws SQLException {
        try {
            jdbcTemplate.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Error executing insert into temporary table", e);
        }
    }

    @Override
    public List<SalesReportResponse> retrieveAuditData(String sql) throws SQLException {
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                SalesReportResponse response = new SalesReportResponse();
                response.setField1(rs.getString("field1"));
                response.setField2(rs.getString("field2"));
                return response;
            });
        } catch (SQLException e) {
            throw new SQLException("Error retrieving audit data", e);
        }
    }
}