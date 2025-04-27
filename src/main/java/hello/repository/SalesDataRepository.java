package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.model.SalesData;
import java.util.List;

public interface SalesDataRepository extends JpaRepository<SalesData, Long> {
    
    @Query("SELECT sd FROM SalesData sd WHERE sd.orderId = :orderId AND sd.tempItems = :tempItems")
    List<SalesData> findSalesDataByOrderIdAndTempItems(@Param("orderId") Long orderId, @Param("tempItems") String tempItems);
}