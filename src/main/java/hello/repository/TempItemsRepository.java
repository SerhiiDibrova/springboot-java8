package hello.repository;

import hello.entity.TempItems;
import hello.entity.DisplayOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TempItemsRepository extends JpaRepository<TempItems, Integer> {
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO #TempItems (orderId, itemDetails) VALUES (:orderId, :itemDetails)", nativeQuery = true)
    void insertTempItemsData(Integer orderId, String itemDetails);

    List<TempItems> findByOrderId(Integer orderId);

    @Query("SELECT di FROM DisplayOptions di JOIN CustomConfig cc ON cc.configId = di.configId WHERE cc.module = 'SALES' AND cc.orderId = :orderId")
    List<DisplayOptions> findDisplayOptionsForSales(Integer orderId);

    @Query("SELECT di FROM DisplayOptions di JOIN LegacyConfig lc ON lc.configId = di.configId WHERE lc.module = 'MARKETING_DATA' AND lc.orderId = :orderId")
    List<DisplayOptions> findDisplayOptionsForMarketingData(Integer orderId);
}