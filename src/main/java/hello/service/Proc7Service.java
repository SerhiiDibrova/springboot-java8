

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
@Transactional
public class Proc7Service {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Proc7Service(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String getNameById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        try {
            return jdbcTemplate.queryForObject("SELECT dbo.func_7(?)", new Object[]{id}, new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getString(1);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Error executing proc_7 procedure", e);
        }
    }
}