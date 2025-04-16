

package hello.service;

import hello.model.Table5;
import hello.repository.Func5Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Proc5Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc5Service.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Func5Service func5Service;

    public void processInput(int input) {
        if (input < 0) {
            LOGGER.error("Invalid input: {}", input);
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }

        try {
            int result = func5Service.func5(input);
            if (result == 0) {
                LOGGER.warn("Result of Func5Service call is null or zero for input: {}", input);
            }
            Table5 table5 = new Table5(input, result, LocalDateTime.now());
            jdbcTemplate.update("INSERT INTO table_5 (input, result, date_time) VALUES (?, ?, ?)", table5.getInput(), table5.getResult(), table5.getDateTime());
            LOGGER.info("Successfully inserted data into table_5 for input: {}", input);
        } catch (Exception e) {
            LOGGER.error("Error executing jdbcTemplate.update for input: {}", input, e);
            throw new RuntimeException("Error executing jdbcTemplate.update", e);
        }
    }
}