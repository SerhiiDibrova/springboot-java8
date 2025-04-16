

package hello.service;

import hello.model.Table19;
import hello.repository.NameRetrievalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;

@Service
public class Table19Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table19Service.class);

    private final JdbcTemplate jdbcTemplate;
    private final NameRetrievalService nameRetrievalService;

    public Table19Service(DataSource dataSource, NameRetrievalService nameRetrievalService) {
        Assert.notNull(dataSource, "DataSource must not be null");
        Assert.notNull(nameRetrievalService, "NameRetrievalService must not be null");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.nameRetrievalService = nameRetrievalService;
    }

    public void insertTable19Record(int inputId) {
        Assert.isTrue(inputId > 0, "Input ID must be greater than 0");
        try {
            String name = nameRetrievalService.func_9(inputId);
            Table19 table19 = new Table19();
            table19.setInput(inputId);
            table19.setName(name);
            jdbcTemplate.update("INSERT INTO table_19 (input, name) VALUES (?, ?)", inputId, name);
        } catch (SQLException e) {
            LOGGER.error("Error inserting record into table_19", e);
            throw new RuntimeException("Error inserting record into table_19", e);
        }
    }
}