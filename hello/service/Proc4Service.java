

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Service
public class Proc4Service {

    private final JdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(Proc4Service.class);

    @Autowired
    public Proc4Service(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertRecord(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be greater than 0");
        }
        try {
            jdbcTemplate.update("INSERT INTO table_4 (id) VALUES (?)", id);
            if (storedProcExists()) {
                jdbcTemplate.execute("CALL proc_4()");
                logger.info("Executed stored procedure 'proc_4'");
            } else {
                logger.warn("Stored procedure 'proc_4' does not exist");
            }
        } catch (Exception e) {
            logger.error("Error inserting record or executing stored procedure", e);
            throw new RuntimeException(e);
        }
    }

    private boolean storedProcExists() {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            return metaData.getProcedures(null, null, "proc_4").next();
        } catch (SQLException e) {
            logger.error("Error checking if stored procedure exists", e);
            return false;
        }
    }
}