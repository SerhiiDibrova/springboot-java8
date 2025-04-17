

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;

@Service
public class Trigger8Service {

    private final Table8Repository table8Repository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Trigger8Service(Table8Repository table8Repository, DataSource dataSource) {
        this.table8Repository = table8Repository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void executeProcedureAfterInsertWithId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        try {
            jdbcTemplate.update("CALL proc_8(?)", id);
        } catch (Exception e) {
            throw new RuntimeException("Error executing stored procedure", e);
        }
    }
}