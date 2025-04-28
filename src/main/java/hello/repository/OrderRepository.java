package hello.repository;

import hello.entity.OrderDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderDB, UUID> {
    Optional<OrderDB> findById(UUID orderId);
    Optional<OrderDB> findByCustomerId(UUID customerId);
    List<OrderDB> findByStatus(String status);
}