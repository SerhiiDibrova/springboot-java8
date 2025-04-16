

package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class NameRetrievalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameRetrievalService.class);
    private static final String TABLE_NAME = "names";
    private static final String SQL_QUERY = "SELECT id FROM " + TABLE_NAME + " WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NameRetrievalService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long getIdById(Long id) {
        if (id == null) {
            LOGGER.error("Input 'id' parameter is null");
            throw new IllegalArgumentException("Input 'id' parameter cannot be null");
        }

        try {
            return jdbcTemplate.queryForObject(SQL_QUERY, new Object[]{id}, Long.class);
        } catch (Exception e) {
            LOGGER.error("Error retrieving id by id", e);
            throw new RuntimeException("Error retrieving id by id", e);
        }
    }
}