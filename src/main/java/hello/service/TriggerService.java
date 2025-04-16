

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractor;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Service
public class TriggerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TriggerService.class);

    private final TriggerRepository triggerRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TriggerService(TriggerRepository triggerRepository, DataSource dataSource) {
        this.triggerRepository = triggerRepository;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void executeTrigger(Integer id) {
        if (id == null) {
            LOGGER.error("Id is null");
            throw new IllegalArgumentException("Id is null");
        }

        try {
            LOGGER.info("Executing stored procedure proc_1 with id {}", id);
            jdbcTemplate.execute("CALL proc_1(?)", id);
            LOGGER.info("Stored procedure proc_1 executed successfully with id {}", id);
        } catch (Exception e) {
            LOGGER.error("Error executing stored procedure proc_1 with id {}", id, e);
            throw new RuntimeException("Error executing stored procedure proc_1", e);
        }
    }
}