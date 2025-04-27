package hello.service;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayOptionRowMapper implements RowMapper<DisplayOption> {
    @Override
    public DisplayOption mapRow(ResultSet rs, int rowNum) throws SQLException {
        DisplayOption displayOption = new DisplayOption();
        try {
            displayOption.setId(rs.getInt("id"));
            displayOption.setName(rs.getString("name"));
            displayOption.setValue(rs.getString("value"));
            displayOption.setDescription(rs.getString("description"));
            displayOption.setActive(rs.getBoolean("active"));
        } catch (SQLException e) {
            throw new SQLException("Error mapping row to DisplayOption", e);
        }
        return displayOption;
    }
}