

package hello.service;

import hello.entity.Table8;
import hello.service.NameRetrievalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Trigger8Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Trigger8Service.class);

    private final NameRetrievalService nameRetrievalService;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Trigger8Service(NameRetrievalService nameRetrievalService, JdbcTemplate jdbcTemplate) {
        this.nameRetrievalService = nameRetrievalService;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeTriggerAfterInsert(Table8 table8) {
        if (table8 == null) {
            LOGGER.error("Table8 object is null");
            return;
        }

        Long id = nameRetrievalService.getId(table8);
        if (id == null) {
            LOGGER.error("Id value is null");
            return;
        }

        try {
            jdbcTemplate.update("CALL proc_8(?)", id);
            LOGGER.info("Stored procedure proc_8 executed successfully with id {}", id);
        } catch (Exception e) {
            LOGGER.error("Error executing stored procedure proc_8 with id {}", id, e);
        }
    }
}