package hello.repository;

import hello.entity.OrderDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface OrderRepository extends JpaRepository<OrderDB, UUID> {
    List<OrderDB> findByUserEmail(String userEmail);
    List<OrderDB> findAllByOrderByCreatedAtDesc();
    
    @Query("SELECT o FROM OrderDB o WHERE o.id = :orderId")
    OrderDB findById(@Param("orderId") UUID orderId);
    
    Optional<OrderDB> findById(UUID id);
}