

package hello.service;

import java.util.Date;
import java.sql.Timestamp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import hello.model.Table3;
import hello.service.Func3Service;

public class Proc3Service {

    private final JdbcTemplate jdbcTemplate;
    private final Func3Service func3Service;

    public Proc3Service(JdbcTemplate jdbcTemplate, Func3Service func3Service) {
        this.jdbcTemplate = jdbcTemplate;
        this.func3Service = func3Service;
    }

    public void executeProc3(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        String name = func3Service.func3(input);
        if (name == null) {
            throw new RuntimeException("Func3Service returned null value");
        }

        Table3 table3 = new Table3(input, name, new Timestamp(new Date().getTime()));
        try {
            jdbcTemplate.update("INSERT INTO table_3 (input, name, date_time) VALUES (?, ?, ?)", 
                table3.getInput(), table3.getName(), table3.getDateTime());
        } catch (Exception e) {
            throw new RuntimeException("Error inserting data into table_3", e);
        }
    }
}