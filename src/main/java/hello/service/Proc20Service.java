

package hello.service;

import java.util.Date;
import java.sql.Timestamp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.model.Table0;
import hello.service.Func0Service;

public class Proc20Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(Proc20Service.class);
    private final JdbcTemplate jdbcTemplate;
    private final Func0Service func0Service;

    public Proc20Service(JdbcTemplate jdbcTemplate, Func0Service func0Service) {
        this.jdbcTemplate = jdbcTemplate;
        this.func0Service = func0Service;
    }

    public void execute(int input) {
        if (input <= 0) {
            LOGGER.error("Invalid input: {}", input);
            throw new IllegalArgumentException("Input must be a positive integer");
        }

        String name = func0Service.generateName();
        Timestamp createdAt = new Timestamp(new Date().getTime());

        try {
            jdbcTemplate.update("INSERT INTO table_0 (id, name, created_at) VALUES (?, ?, ?)", input, name, createdAt);
        } catch (Exception e) {
            LOGGER.error("Error executing proc_20 procedure", e);
            throw new RuntimeException("Error executing proc_20 procedure", e);
        }
    }
}