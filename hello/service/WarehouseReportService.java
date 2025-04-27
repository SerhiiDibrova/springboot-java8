package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WarehouseReportService implements WarehouseReportServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private TempItemsRepository tempItemsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void populateWarehouseReport() {
        try {
            entityManager.createNativeQuery("CREATE TEMPORARY TABLE temp_items AS SELECT * FROM items").executeUpdate();
            logger.info("Temporary table temp_items created.");

            Query insertQuery = entityManager.createNativeQuery("INSERT INTO temp_items SELECT * FROM items WHERE condition = 'new'");
            int rowsInserted = insertQuery.executeUpdate();
            logger.info(rowsInserted + " rows inserted into temp_items.");

        } catch (Exception e) {
            logger.error("Error occurred while populating warehouse report: ", e);
            throw e;
        } finally {
            try {
                entityManager.createNativeQuery("DROP TABLE IF EXISTS temp_items").executeUpdate();
                logger.info("Temporary table temp_items dropped.");
            } catch (Exception e) {
                logger.error("Error occurred while dropping temporary table: ", e);
            }
        }
    }
}