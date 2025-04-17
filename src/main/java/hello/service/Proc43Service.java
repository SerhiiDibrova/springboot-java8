

package hello.service;

import hello.entity.Table3Entity;
import hello.repository.Table3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Proc43Service {

    private final JdbcTemplate jdbcTemplate;
    private final Table3Repository table3Repository;
    private final RestTemplate restTemplate;

    @Autowired
    public Proc43Service(JdbcTemplate jdbcTemplate, Table3Repository table3Repository, RestTemplate restTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.table3Repository = table3Repository;
        this.restTemplate = restTemplate;
    }

    public void createRecord(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        try {
            String stringValue = jdbcTemplate.queryForObject("SELECT dbo.func_3(?)", String.class, input);
            if (stringValue == null) {
                throw new RuntimeException("Failed to retrieve string value");
            }
            Table3Entity entity = new Table3Entity(input, stringValue, LocalDateTime.now());
            table3Repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create record", e);
        }
    }
}