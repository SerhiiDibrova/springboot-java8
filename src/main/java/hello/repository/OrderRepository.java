

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o FROM OrderEntity o WHERE o.customerId = :customerId")
    List<OrderEntity> findByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT o FROM OrderEntity o WHERE o.orderStatus = :orderStatus")
    List<OrderEntity> findByOrderStatus(@Param("orderStatus") String orderStatus);

    @Query("SELECT o FROM OrderEntity o WHERE o.orderDate >= :startDate AND o.orderDate <= :endDate")
    List<OrderEntity> findByOrderDateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query("SELECT o FROM OrderEntity o WHERE o.totalAmount >= :minAmount AND o.totalAmount <= :maxAmount")
    List<OrderEntity> findByTotalAmountBetween(@Param("minAmount") Double minAmount, @Param("maxAmount") Double maxAmount);
}