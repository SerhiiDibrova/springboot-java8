package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalesDataRepository extends JpaRepository<SalesData, Long> {
    
    @Query("SELECT sd FROM SalesData sd WHERE sd.orderId = ?1 AND sd.tempItems = ?2")
    List<SalesData> findByOrderIdAndTempItems(Long orderId, String tempItems);
}