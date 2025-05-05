package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class TempItemsRepositoryImpl implements TempItemsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void executeCreateTempItemsTable(String sql) {
        jdbcTemplate.execute(sql);
    }

    @Override
    public List<DisplayOptions> executeRetrieveDisplayOptions(String sql) {
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            DisplayOptions displayOptions = new DisplayOptions();
            displayOptions.setOrderId(rs.getInt("order_id"));
            displayOptions.setConfigId(rs.getInt("config_id"));
            // Set other properties as needed
            return displayOptions;
        });
    }
}