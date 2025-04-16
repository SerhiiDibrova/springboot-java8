

package hello.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import hello.model.Name;
import hello.service.NameCreationService;
import hello.service.NameRetrievalService;

@Service
public class NameCreationServiceImpl implements NameCreationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameCreationServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NameRetrievalService nameRetrievalService;

    @Override
    public void createNameRecord(Name name) {
        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(jdbcTemplate, "JdbcTemplate cannot be null");
        Assert.notNull(nameRetrievalService, "NameRetrievalService cannot be null");

        try {
            nameRetrievalService.dboFunc9(name);
            jdbcTemplate.update("INSERT INTO table_9 (column1, column2, column3) VALUES (?, ?, ?)", name.getColumn1(), name.getColumn2(), name.getColumn3());
        } catch (Exception e) {
            LOGGER.error("Error creating name record", e);
            throw e;
        }
    }
}