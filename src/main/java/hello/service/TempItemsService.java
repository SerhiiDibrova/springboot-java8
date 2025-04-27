package hello.service;

import hello.repository.TempItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TempItemsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TempItemsRepository tempItemsRepository;

    @Transactional
    public void processTempItems() {
        try {
            createTemporaryTable();
            List<DisplayOption> displayOptions = retrieveDisplayOptions();
            // Additional processing with displayOptions
        } catch (SQLException e) {
            // Handle SQL exception
        } finally {
            cleanupTemporaryTable();
        }
    }

    @Transactional(readOnly = true)
    public List<DisplayOption> retrieveDisplayOptions() throws SQLException {
        String sql = "SELECT di.* FROM TempItems ti " +
                     "JOIN CustomConfig cc ON ti.configId = cc.id " +
                     "JOIN LegacyConfig lc ON ti.legacyId = lc.id " +
                     "JOIN DisplayOptions di ON ti.displayOptionId = di.id";

        return jdbcTemplate.query(sql, new RowMapper<DisplayOption>() {
            @Override
            public DisplayOption mapRow(ResultSet rs, int rowNum) throws SQLException {
                DisplayOption displayOption = new DisplayOption();
                displayOption.setId(rs.getInt("id"));
                displayOption.setName(rs.getString("name"));
                displayOption.setValue(rs.getString("value"));
                return displayOption;
            }
        });
    }

    private void createTemporaryTable() {
        // Implementation for creating temporary table
    }

    private void cleanupTemporaryTable() {
        // Implementation for cleaning up temporary table
    }
}