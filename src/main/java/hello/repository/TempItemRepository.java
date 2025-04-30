package hello.repository; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param; 
import hello.entity.TempItem; 
import hello.entity.DisplayOption; 
import org.springframework.dao.DataAccessException; 
import org.springframework.transaction.annotation.Transactional; 
import java.util.List; 

@Transactional
public interface TempItemRepository extends JpaRepository<TempItem, Long> { 
    List<TempItem> findByOrderId(Long orderId) throws DataAccessException; 

    @Query("SELECT DISTINCT d FROM DisplayOption d JOIN TempItem t ON d.configId = t.configId JOIN CustomConfig c ON t.configId = c.id")
    List<DisplayOption> findDisplayOptionsForSales() throws DataAccessException; 

    @Query("SELECT DISTINCT d FROM DisplayOption d JOIN TempItem t ON d.configId = t.configId JOIN LegacyConfig l ON t.configId = l.id")
    List<DisplayOption> findDisplayOptionsForMarketingData() throws DataAccessException; 
}