package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    @Modifying
    @Transactional(rollbackFor = DataAccessException.class)
    void insertTempItems(Integer orderId, String xmlData) throws DataAccessException;

    @Query(value = "CREATE TABLE #TempItems (order_id INT, config_id INT)", nativeQuery = true)
    void createTempItemsTable();

    @Query(value = "SELECT di.* FROM #TempItems ti JOIN CustomConfig cc ON ti.order_id = cc.order_id JOIN DisplayOptions di ON cc.config_id = di.config_id WHERE cc.module = 'SALES'", nativeQuery = true)
    List<DisplayOptionsDTO> retrieveDisplayOptionsForSales();

    @Query(value = "SELECT di.* FROM #TempItems ti JOIN LegacyConfig lc ON ti.order_id = lc.order_id JOIN DisplayOptions di ON lc.config_id = di.config_id WHERE lc.module = 'MARKETING_DATA'", nativeQuery = true)
    List<DisplayOptionsDTO> retrieveDisplayOptionsForMarketingData();

    @Query(value = "SELECT * FROM (SELECT di.* FROM #TempItems ti JOIN CustomConfig cc ON ti.order_id = cc.order_id JOIN DisplayOptions di ON cc.config_id = di.config_id WHERE cc.module = 'SALES') AS sales UNION SELECT di.* FROM #TempItems ti JOIN LegacyConfig lc ON ti.order_id = lc.order_id JOIN DisplayOptions di ON lc.config_id = di.config_id WHERE lc.module = 'MARKETING_DATA'", nativeQuery = true)
    List<DisplayOptionsDTO> combineResults();
}