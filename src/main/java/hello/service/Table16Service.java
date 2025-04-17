

package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
public class Table16Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table16Service.class);

    private final Table16Repository table16Repository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Table16Service(DataSource dataSource, Table16Repository table16Repository) {
        this.table16Repository = table16Repository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertRecord(Long input) {
        if (input == null) {
            LOGGER.error("Input is null");
            return;
        }

        try {
            String stringValue = jdbcTemplate.queryForObject("SELECT dbo.func_6(?)", String.class, input);
            if (stringValue == null) {
                LOGGER.error("stringValue is null");
                return;
            }
            table16Repository.save(new Table16(stringValue));
        } catch (Exception e) {
            LOGGER.error("Error inserting record", e);
        }
    }
}