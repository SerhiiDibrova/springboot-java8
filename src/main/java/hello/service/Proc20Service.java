

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Proc20Service {

    private final JdbcTemplate jdbcTemplate;
    private final String tableName;

    @Autowired
    public Proc20Service(JdbcTemplate jdbcTemplate, @Value("${table.name}") String tableName) {
        this.jdbcTemplate = jdbcTemplate;
        this.tableName = tableName;
    }

    public void insertTable0(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        try {
            String name = jdbcTemplate.queryForObject("SELECT dbo.func_0(?)", new Object[]{input}, String.class);
            jdbcTemplate.update("INSERT INTO " + tableName + " (name, date_time) VALUES (?, ?)", name, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (Exception e) {
            throw new RuntimeException("Error inserting into table", e);
        }
    }

    public String getTableName() {
        return tableName;
    }
}