

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Proc32Service {

    private final Table2Service table2Service;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Proc32Service(Table2Service table2Service, JdbcTemplate jdbcTemplate) {
        this.table2Service = table2Service;
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getName(int id) {
        return table2Service.getName(id);
    }

    public void insertIntoTable12(int id, String name) {
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        jdbcTemplate.update("INSERT INTO table_12 (id, name, created_at) VALUES (?, ?, ?)", id, name, currentDateTime);
    }
}