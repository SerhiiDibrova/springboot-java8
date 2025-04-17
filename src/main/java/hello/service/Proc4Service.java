

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.repository.Table4Repository;
import hello.model.Table4;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class Proc4Service {

    private final Logger logger = LoggerFactory.getLogger(Proc4Service.class);

    private final JdbcTemplate jdbcTemplate;
    private final Table4Repository table4Repository;

    @Autowired
    public Proc4Service(JdbcTemplate jdbcTemplate, Table4Repository table4Repository) {
        this.jdbcTemplate = jdbcTemplate;
        this.table4Repository = table4Repository;
    }

    public void executeProc(int input) {
        try {
            String name = dboFunc4(input);
            Table4 table4 = new Table4(name);
            table4Repository.save(table4);
        } catch (Exception e) {
            logger.error("Error executing proc_4 with input: " + input, e);
        }
    }

    public void executeProc(Integer id) {
        try {
            jdbcTemplate.execute("EXEC proc_4 ?", (PreparedStatementCallback<Void>) ps -> {
                ps.setInt(1, id);
                ps.execute();
                return null;
            });
        } catch (Exception e) {
            logger.error("Error executing proc_4 with id: " + id, e);
        }
    }

    private String dboFunc4(int input) {
        // implementation of dbo.func_4 function in Java
        // this method should be implemented according to the actual logic of dbo.func_4 function
        // for example:
        return "result_" + input;
    }
}