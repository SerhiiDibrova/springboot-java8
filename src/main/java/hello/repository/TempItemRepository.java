package hello.repository;

import hello.entity.TempItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Integer> {

    @Query("SELECT DISTINCT ti FROM TempItem ti JOIN CustomConfig cc ON ti.orderId = cc.orderId JOIN DisplayOptions do ON cc.configId = do.configId WHERE do.module = 'SALES'")
    List<TempItem> findDisplayOptionsForSales();

    @Query("SELECT DISTINCT ti FROM TempItem ti JOIN LegacyConfig lc ON ti.orderId = lc.orderId JOIN DisplayOptions do ON lc.configId = do.configId WHERE do.module = 'MARKETING_DATA'")
    List<TempItem> findDisplayOptionsForMarketingData();

    @Query("SELECT DISTINCT ti FROM TempItem ti JOIN CustomConfig cc ON ti.orderId = cc.orderId JOIN DisplayOptions do ON cc.configId = do.configId WHERE do.module = 'SALES' " +
           "UNION " +
           "SELECT DISTINCT ti FROM TempItem ti JOIN LegacyConfig lc ON ti.orderId = lc.orderId JOIN DisplayOptions do ON lc.configId = do.configId WHERE do.module = 'MARKETING_DATA'")
    List<TempItem> combineResults();
}