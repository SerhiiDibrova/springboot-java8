package hello.service;

import hello.repository.TempItemsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempItemsService {

    private final TempItemsRepository tempItemsRepository;
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TempItemsService.class);

    public TempItemsService(TempItemsRepository tempItemsRepository, JdbcTemplate jdbcTemplate) {
        this.tempItemsRepository = tempItemsRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTempItemsTable() {
        String sql = "CREATE TEMPORARY TABLE #TempItems (order_id INT, config_id INT);";
        try {
            tempItemsRepository.executeCreateTempItemsTable(sql);
        } catch (DataAccessException e) {
            handleError(e);
        }
    }

    public List<DisplayOptions> retrieveDisplayOptions() {
        String sql = "SELECT di.* FROM #TempItems ti " +
                     "JOIN CustomConfig cc ON ti.order_id = cc.order_id " +
                     "JOIN DisplayOptions di ON cc.config_id = di.config_id " +
                     "WHERE cc.module = 'SALES' " +
                     "UNION " +
                     "SELECT di.* FROM #TempItems ti " +
                     "JOIN LegacyConfig lc ON ti.order_id = lc.order_id " +
                     "JOIN DisplayOptions di ON lc.config_id = di.config_id " +
                     "WHERE lc.module = 'MARKETING_DATA';";
        return tempItemsRepository.executeRetrieveDisplayOptions(sql);
    }

    public void dropTempItemsTable() {
        String sql = "DROP TABLE #TempItems;";
        tempItemsRepository.executeDropTempItemsTable(sql);
    }

    public void handleError(DataAccessException e) {
        logger.error("Database error occurred: {}", e.getMessage());
        throw e;
    }
}