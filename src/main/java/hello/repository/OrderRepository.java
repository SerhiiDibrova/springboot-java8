package hello.repository;

import hello.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderId(@Param("orderId") Long orderId);
    
    List<Order> findByStatus(@Param("status") String status);
    
    List<Order> findByOrderDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}