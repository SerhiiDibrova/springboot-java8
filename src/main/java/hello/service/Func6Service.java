

package hello.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class Func6Service {

    private static final String TABLE_NAME = "table_name";
    private static final String COLUMN_NAME = "string_value";
    private static final String ID_COLUMN_NAME = "id";

    private final JdbcTemplate jdbcTemplate;

    public Func6Service(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String getStringValue(Long input) {
        Assert.notNull(input, "Input must not be null");

        try {
            return jdbcTemplate.queryForObject(getQuery(), new Object[]{input}, getStringValueMapper());
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve string value", e);
        }
    }

    private String getQuery() {
        return String.format("SELECT %s FROM %s WHERE %s = ?", COLUMN_NAME, TABLE_NAME, ID_COLUMN_NAME);
    }

    private RowMapper<String> getStringValueMapper() {
        return new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(COLUMN_NAME);
            }
        };
    }
}