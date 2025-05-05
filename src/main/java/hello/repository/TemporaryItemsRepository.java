package hello.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TemporaryItemsRepository extends CrudRepository<TemporaryItems, Long> {
    @Query(value = "CREATE TEMPORARY TABLE #TempItems AS SELECT * FROM SomeSourceTable; " +
                   "SELECT di.* FROM #TempItems ti " +
                   "JOIN CustomConfig cc ON ti.order_id = cc.order_id " +
                   "JOIN DisplayOptions di ON cc.config_id = di.config_id " +
                   "WHERE cc.module = 'SALES' " +
                   "UNION " +
                   "SELECT di.* FROM #TempItems ti " +
                   "JOIN LegacyConfig lc ON ti.order_id = lc.order_id " +
                   "JOIN DisplayOptions di ON lc.config_id = di.config_id " +
                   "WHERE lc.module = 'MARKETING_DATA';", nativeQuery = true)
    List<DisplayOptionsDTO> executeRetrieveDisplayOptions();
}